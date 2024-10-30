import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      String s = br.readLine();

      int left = 0;
      int right = s.length() - 1;

      while (left < right) {
        if(s.charAt(left) != s.charAt(right)) {
          if (palindrome(s, left + 1, right)) {
            bw.write(1 + "\n");
          } else if (palindrome(s, left,  right - 1)) {
            bw.write(1 + "\n");
          } else {
            bw.write(2 + "\n");
          }
          break;
        }

        if(left + 1 >= right - 1) {
          bw.write(0 + "\n");
        }

        left++;
        right--;

      }
    }

    bw.flush();
    bw.close();

  }

  private static boolean palindrome(String s, int left, int right) {
    while (left < right) {
      if(s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}