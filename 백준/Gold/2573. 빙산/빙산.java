import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
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

    int year = 0;
    while(true) {
      int count = 0;
      boolean[][] visited = new boolean[N][M];
      for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
          if(matrix[i][j] != 0 && !visited[i][j]) {
            dfs(i, j, visited, matrix, N, M);
            count++;
          }
        }
      }

      if(count >= 2) {
        bw.write(year + "");
        break;
      } else if(count == 0) {
        bw.write(0 + "");
        break;
      }

      int[][] newMatrix = new int[N][M];
      for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
          if(matrix[i][j] == 0) continue;
          int waterCount = 0;
          for(int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if(matrix[x][y] == 0) {
              waterCount++;
            }
          }
          newMatrix[i][j] = Math.max(0, matrix[i][j] - waterCount);
        }
      }

      matrix = newMatrix;
      year++;
    }

    bw.flush();
    bw.close();
  }

  private static void dfs(int i, int j, boolean[][] visited, int[][] matrix, int N, int M) {
    visited[i][j] = true;
    for(int k = 0; k < 4; k++) {
      int x = i + dx[k];
      int y = j + dy[k];
      if(x < 0 || y < 0 || x >= N || y >= M) continue;
      if(matrix[x][y] == 0 || visited[x][y]) continue;
      dfs(x, y, visited, matrix, N, M);
    }
  }
}