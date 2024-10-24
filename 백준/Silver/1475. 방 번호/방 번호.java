import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = br.readLine();
    int[] nums = new int[10];
    for (int i = 0; i < input.length(); i++) {
      nums[input.charAt(i) - '0']++;
    }
    int max = 0;
    for (int i = 0; i < 9; i++) {
      if(i == 6) {
        max = Math.max(max, (nums[6] + nums[9] + 1) / 2);
      } else {
        max = Math.max(max, nums[i]);
      }
    }

    bw.write(max + "\n");

    bw.flush();
    bw.close();

  }
}