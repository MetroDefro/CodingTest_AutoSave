import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] inputs = br.readLine().split(" ");
    int N = Integer.parseInt(inputs[0]);
    int K = Integer.parseInt(inputs[1]);

    int[][] arr = new int[6][2];
    for(int i = 1; i <= N; i++) {
      inputs = br.readLine().split(" ");
      int S = Integer.parseInt(inputs[0]);
      int Y = Integer.parseInt(inputs[1]);
      arr[Y-1][S]++;
    }

    int sum = 0;
    for(int i = 0; i < 6; i++) {
      for(int j = 0; j < 2; j++) {
        if(arr[i][j] % K != 0) {
          sum++;
        }
        sum += arr[i][j] / K;
      }
    }

    bw.write(sum + "");

    bw.flush();
    bw.close();

  }
}