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
    int[] dp = new int[N < 5 ? 6 : N + 1];
    dp[0] = 100000;
    dp[1] = 100000;
    dp[2] = 1;
    dp[3] = 100000;
    dp[4] = 2;
    dp[5] = 1;
    for (int i = 6; i <= N; i++) {
      dp[i] = Math.min(dp[i - 5], dp[i - 2]) + 1;
    }

    if(dp[N] >= 100000) {
      bw.write(-1 + "\n");
    } else {
      bw.write(dp[N] + "\n");
    }

    bw.flush();
    bw.close();
  }
}