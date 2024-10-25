import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    LinkedList<Character> list = new LinkedList();
    String str = br.readLine();
    for(int i = 0; i < str.length(); i++) {
      list.add(str.charAt(i));
    }
    ListIterator<Character> cursor = list.listIterator(list.size());
    int N = Integer.parseInt(br.readLine());
    while (N-- > 0) {
      str = br.readLine();
      String[] inputs = str.split(" ");
      switch (inputs[0]) {
        case "L" -> {
          if(cursor.hasPrevious()) {
            cursor.previous();
          }
        }
        case "D" -> {
          if(cursor.hasNext()) {
            cursor.next();
          }
        }
        case "B" -> {
          if(cursor.hasPrevious()) {
            cursor.previous();
            cursor.remove();
          }
        }
        case "P" -> {
          cursor.add(inputs[1].charAt(0));
        }
      }
    }

    for(char c : list) {
      bw.write(c);
    }

    bw.flush();
    bw.close();

  }
}