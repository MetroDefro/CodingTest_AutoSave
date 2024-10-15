import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    String[] input = bf.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);
    HashMap<String, Integer> wordMap = new HashMap();
    for(int i=0; i<N; i++) {
      String word = bf.readLine();
      if(word.length() < M)
        continue;

      wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
    }

    List<String> words = new ArrayList<>(wordMap.keySet());
    words.sort(new Comparator<String>() {

      @Override
      public int compare(String o1, String o2) {
        if (!Objects.equals(wordMap.get(o1), wordMap.get(o2))) {
          return wordMap.get(o2).compareTo(wordMap.get(o1));
        }

        if (o1.length() != o2.length()) {
          return o2.length() - o1.length();
        }

        return o1.compareTo(o2);
      }
    });

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for(String word : words) {
      bw.write(word+"\n");
    }

    bw.flush();
    bw.close();

  }

}