import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] arr = new int[26];
    String str1 = br.readLine();
    String str2 = br.readLine();
    int sum = 0;
    for(int alphabet = 0; alphabet < str1.length(); alphabet++) {
      arr[str1.charAt(alphabet) - 'a']++;
    }
    for(int alphabet = 0; alphabet < str2.length(); alphabet++) {
      arr[str2.charAt(alphabet) - 'a']--;
    }
    for(int alphabet = 0; alphabet < 26; alphabet++) {
      sum += Math.abs(arr[alphabet]);
    }
    bw.write(sum + "\n");
    bw.flush();
    bw.close();

  }
}