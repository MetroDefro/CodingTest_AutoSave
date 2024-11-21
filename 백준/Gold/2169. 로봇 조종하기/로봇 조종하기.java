import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] matrix = new int[N][M];
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < M; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[][] dp = new int[N][M];
    dp[0][0] = matrix[0][0];
    for(int i = 1; i < M; i++) {
      dp[0][i] = dp[0][i-1] + matrix[0][i];
    }

    for(int i = 1; i < N; i++) {
      int[][] temp = new int[2][M];
      temp[0][0] = dp[i-1][0] + matrix[i][0];
      for(int j = 1; j < M; j++) {
        temp[0][j] = Math.max(dp[i - 1][j], temp[0][j - 1]) + matrix[i][j];
      }
      temp[1][M-1] = dp[i-1][M-1] + matrix[i][M-1];
      for(int j = M - 2; j >= 0; j--) {
        temp[1][j] = Math.max(dp[i - 1][j], temp[1][j + 1]) + matrix[i][j];
      }
      for(int j = 0; j < M; j++) {
        dp[i][j] = Math.max(temp[0][j], temp[1][j]);
      }
    }

    bw.write(dp[N-1][M-1] + "");


    bw.flush();
    bw.close();
  }

}