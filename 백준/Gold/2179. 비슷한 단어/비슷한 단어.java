import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    HashMap<String, Integer> map = new HashMap<>();
    int s = 0;
    int t = 1;
    int length = 0;
    String[] arr = new String[N];
    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      arr[i] = line;
      for (int j = line.length(); j > 0; j--) {
        String key = line.substring(0, j);
        if(key.length() < length) break;
        if(map.containsKey(key)) {
          if(key.length() == length && map.get(key) > s) break;
          if(key.length() == length && map.get(key) == s && i > t) break;
          s = map.get(key);
          t = i;
          length = key.length();
          break;
        }
        map.put(key, i);
      }
    }
    bw.write(arr[s] + "\n" + arr[t]);
    bw.flush();
    bw.close();
  }

}