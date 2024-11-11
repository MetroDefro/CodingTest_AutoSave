import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  private static int[] dx = new int[]{1, -1, 0, 0};
  private static int[] dy = new int[]{0, 0, -1, 1};
  private static int N;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    boolean[][] arr = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        arr[i][j] = st.nextToken().equals("1");
      }
    }

    int[][] island = new int[N][N];
    int count = 0;
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        if(island[i][j] == 0 && arr[i][j]) {
          count++;
          dfs(arr, island, i, j, count);
        }
      }
    }

    int min = Integer.MAX_VALUE;
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        if(!arr[i][j]) continue;
        int islandNum = island[i][j];
        int[][] dist = new int[N][N];
        for(int i2 = 0; i2 < N; i2++) {
          for(int j2 = 0; j2 < N; j2++) {
            dist[i2][j2] = -1;
          }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { i, j, 0 });
        while (!q.isEmpty()) {
          int[] cur = q.poll();
          if(arr[cur[0]][cur[1]] && island[cur[0]][cur[1]] != islandNum) {
            min = Math.min(min, cur[2] - 1);
            continue;
          }
          for(int k = 0; k < 4; k++) {
            int x = cur[0] + dx[k];
            int y = cur[1] + dy[k];
            if(x < 0 || y < 0 || x >= N || y >= N) continue;
            if(island[x][y] == islandNum) continue;
            if(dist[x][y] != -1 && dist[x][y] <= cur[2] + 1) continue;
            if(dist[x][y] > min) continue;
            dist[x][y] = cur[2] + 1;
            q.add(new int[] {x, y, cur[2] + 1});
          }
        }
      }
    }

    bw.write(min+"");

    bw.flush();
    bw.close();
  }

  private static void dfs(boolean[][] arr, int[][] visited, int i, int j, int num) {
    visited[i][j] = num;
    for(int k = 0; k < 4; k++) {
      if(i + dx[k] < 0 || j + dy[k] < 0 || i + dx[k] >= N || j + dy[k] >= N) continue;
      if(!arr[i + dx[k]][j + dy[k]]) continue;
      if(visited[i + dx[k]][j + dy[k]] != 0) continue;
      dfs(arr, visited, i + dx[k], j + dy[k], num);
    }
  }
}