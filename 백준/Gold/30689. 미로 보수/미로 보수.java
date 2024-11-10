import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static char[][] arr = new char[2000][2000];
  static int[][] cost = new int[2000][2000];
  static boolean[][] done = new boolean[2000][2000];
  static boolean[][] visited = new boolean[2000][2000];
  static int sum = 0;
  static HashMap<Character, Integer> dir = new HashMap<>();
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    dir.put('U', 2);
    dir.put('D', 3);
    dir.put('L', 0);
    dir.put('R', 1);

    for(int i = 0; i < N; i++) {
      String line = br.readLine();
      for(int j = 0; j < M; j++) {
        arr[i][j] = line.charAt(j);
      }
    }

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < M; j++) {
        cost[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(done[i][j]) continue;
        dfs(i, j);
      }
    }

    bw.write(sum + "\n");

    bw.flush();
    bw.close();
  }

  private static void dfs(int i, int j) {
    visited[i][j] = true;
    int d = dir.get(arr[i][j]);
    int nextY = i + dy[d];
    int nextX = j + dx[d];
    if(nextY < 0 || nextX < 0 || nextY >= N || nextX >= M) {
      done[i][j] = true;
      return;
    }
    if(done[nextY][nextX]) {
      done[i][j] = true;
      return;
    }

    if(visited[nextY][nextX]) {
      int y = nextY, x = nextX;
      int min = cost[i][j];
      while (y != i || x != j) {
        min = Math.min(min, cost[y][x]);
        d = dir.get(arr[y][x]);
        y = y + dy[d];
        x = x + dx[d];
      }
      sum += min;
    } else dfs(nextY, nextX);
    done[i][j] = true;
  }
}