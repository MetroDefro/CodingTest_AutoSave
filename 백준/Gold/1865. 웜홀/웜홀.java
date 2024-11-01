import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
  private static int count = 1;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int TC = Integer.parseInt(br.readLine());

    while (TC-- > 0) {
      boolean isBack = false;

      String[] inputs = br.readLine().split(" ");
      int N = Integer.parseInt(inputs[0]);
      int M = Integer.parseInt(inputs[1]);
      int W = Integer.parseInt(inputs[2]);

      List<int[]> edges = new ArrayList<>();

      for(int m = 0; m < M; m++) {
        inputs = br.readLine().split(" ");
        int S = Integer.parseInt(inputs[0]);
        int E = Integer.parseInt(inputs[1]);
        int T = Integer.parseInt(inputs[2]);
        edges.add(new int[]{S, E, T});
        edges.add(new int[]{E, S, T});
      }
      for(int w = 0; w < W; w++) {
        inputs = br.readLine().split(" ");
        int S = Integer.parseInt(inputs[0]);
        int E = Integer.parseInt(inputs[1]);
        int T = Integer.parseInt(inputs[2]);
        edges.add(new int[]{S, E, -T});
      }

      int[] distance = new int[N+1];

      for(int i = 0; i < N; i++) {
        for(int[] edge : edges) {
          if(distance[edge[1]] > distance[edge[0]] + edge[2]) {
            distance[edge[1]] = distance[edge[0]] + edge[2];

            if(i == N - 1) {
              isBack = true;
            }
          }
        }
      }

      bw.write(isBack ? "YES\n" : "NO\n");

    }
    bw.flush();
    bw.close();

  }
}