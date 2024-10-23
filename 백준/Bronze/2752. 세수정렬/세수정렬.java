import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");
    int[] nums = new int[3];
    for (int i = 0; i < 3; i++) {
      nums[i] = Integer.parseInt(inputs[i]);
    }

    Arrays.sort(nums);

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for(int i = 0; i < 3; i++) {
      bw.write(nums[i] + " ");
    }

    bw.flush();
    bw.close();

  }
}