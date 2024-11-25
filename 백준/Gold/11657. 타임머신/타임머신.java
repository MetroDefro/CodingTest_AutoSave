import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    List<int[]> edges = new ArrayList<>();

    while (M-- > 0) {
      st = new StringTokenizer(br.readLine());
      edges.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
    }

    boolean isBack = false;
    long[] dist = new long[N + 1];
    for(int i = 1; i <= N; i++) {
      dist[i] = Long.MIN_VALUE;
    }
    dist[1] = 0;
    for(int i = 0; i < N; i++) {
      for(int[] edge : edges) {
        if(dist[edge[0]] == Long.MIN_VALUE) continue;
        if(dist[edge[1]] != Long.MIN_VALUE && dist[edge[1]] <= dist[edge[0]] + edge[2]) continue;
        dist[edge[1]] = dist[edge[0]] + edge[2];
        if(i == N - 1) {
          isBack = true;
        }
      }
    }

    if(isBack) {
      bw.write("-1\n");
    } else {
      for(int i = 2; i <= N; i++) {
        if(dist[i] == Long.MIN_VALUE) {
          bw.write(-1 + "\n");
        } else {
          bw.write(dist[i] + "\n");
        }
      }
    }
    bw.flush();
    bw.close();
  }
}