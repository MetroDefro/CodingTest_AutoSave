import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int D = Integer.parseInt(st.nextToken());

    int[] dp = new int[D + 1];
    dp[0] = 0;
    List<int[]>[] list = new ArrayList[D + 1];
    for(int i = 1; i <= D; ++i) {
      list[i] = new ArrayList<>();
    }

    for (int i = 0; i < N; i++) {
      String[] line = br.readLine().split(" ");
      if(Integer.parseInt(line[1]) > D) continue;
      list[Integer.parseInt(line[1])].add(new int[]{Integer.parseInt(line[0]), Integer.parseInt(line[2])});
    }

    for(int i = 1; i <= D; ++i) {
      dp[i] = dp[i - 1] + 1;
      for(int j = 0; j < list[i].size(); ++j) {
        dp[i] = Math.min(dp[i], dp[list[i].get(j)[0]] + list[i].get(j)[1]);
      }
    }

    bw.write(dp[D] +"");

    bw.flush();
    bw.close();
  }
}