import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  private static int min = Integer.MAX_VALUE;
  private static int N;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[][] arr = new int[N][N];
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int[][] dist = new int[N][N];
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        dist[i][j] = Integer.MAX_VALUE;
      }
    }
    for(int i = 0; i < N; i++) {
      dist[i][i] = 0;
      dfs(i, i, arr, dist);
    }

    boolean[] visited = new boolean[N];
    visited[K] = true;
    dfs2(K, dist, visited, 1, 0);

    bw.write(min + "\n");

    bw.flush();
    bw.close();
  }

  private static void dfs(int start, int cur, int[][] arr, int[][] dist) {
    for(int i = 0; i < N; i++) {
      if(dist[start][i] > dist[start][cur] + arr[cur][i]) {
        dist[start][i] = dist[start][cur] + arr[cur][i];
        dfs(start, i, arr, dist);
      }
    }
  }

  private static void dfs2(int cur, int[][] arr, boolean[] visited, int depth, int dist) {
    if(depth == N) {
      min = Math.min(min, dist);
    }
    for(int i = 0; i < N; i++) {
      if(!visited[i]) {
        visited[i] = true;
        dfs2(i, arr, visited, depth + 1, dist + arr[cur][i]);
        visited[i] = false;
      }
    }
  }

}