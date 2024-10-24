import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    for(int i = 1; i <= N; i++) {
      String[] inputs = br.readLine().split(" ");

      if(inputs[0].length() != inputs[1].length()) {
        bw.write("Impossible" + "\n");
        continue;
      }
      int[] arr = new int[26];
      for(int alphabet = 0; alphabet < inputs[0].length(); alphabet++) {
        arr[inputs[0].charAt(alphabet) - 'a']++;
        arr[inputs[1].charAt(alphabet) - 'a']--;
      }
      for(int alphabet = 0; alphabet < 26; alphabet++) {

        if(arr[alphabet] != 0) {
          bw.write("Impossible" + "\n");
          break;
        }
        if(alphabet == 25) {
          bw.write("Possible" + "\n");
        }
      }
    }

    bw.flush();
    bw.close();

  }
}