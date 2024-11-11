import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    boolean[][] matrix = new boolean[N][N];
    for(int i = 0; i < N; i++) {
      String line = br.readLine();
      for(int j = 0; j < N; j++) {
        matrix[i][j] = line.charAt(j) == '0';
      }
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    Queue<int[]> q = new LinkedList<>();
    int[][] dist = new int[N][N];
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        dist[i][j] = -1;
      }
    }
    q.add(new int[]{0, 0, 0});
    dist[0][0] = 0;

    while(!q.isEmpty()) {
      int[] cur = q.poll();
      for(int k = 0; k < 4; k++) {
        int x = cur[0] + dx[k];
        int y = cur[1] + dy[k];

        if(x < 0 || y < 0 || x >= N || y >= N) continue;
        if(matrix[x][y]) {
          if(dist[x][y] == -1 || dist[x][y] > cur[2] + 1) {
            dist[x][y] = cur[2] + 1;
            q.add(new int[]{x, y, dist[x][y]});
          }
        } else {
          if(dist[x][y] == -1 || dist[x][y] > cur[2]) {
            dist[x][y] = cur[2];
            q.add(new int[]{x, y, dist[x][y]});
          }
        }
      }
    }
    bw.write(dist[N - 1][N - 1] + "\n");

    bw.flush();
    bw.close();
  }
}