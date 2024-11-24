import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  private static int count = 0;
  private static boolean[][] arr = new boolean[5][5];
  private static int[] dx = {-1, 1, 0, 0};
  private static int[] dy = {0, 0, -1, 1};
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for(int i = 0; i < 5; i++) {
      String s = br.readLine();
      for(int j = 0; j < 5; j++) {
        arr[i][j] = s.charAt(j) == 'Y';
      }
    }
    dfs(new boolean[5][5], -1, 0);
    bw.write(count + "");
    bw.flush();
    bw.close();
  }

  private static void dfs(boolean[][] temp, int prev, int depth) {
    if(depth == 7) {
      bfs(temp, prev / 5, prev % 5);
      return;
    }

    for(int i = prev + 1; i < 25; i++) {
      temp[i / 5][i % 5] = true;
      dfs(temp, i, depth + 1);
      temp[i / 5][i % 5] = false;
    }
  }

  private static void bfs(boolean[][] temp, int r, int c) {
    boolean[][] visited = new boolean[5][5];
    visited[r][c] = true;
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{r, c});

    int memberCount = 1, YCount = arr[r][c] ? 1 : 0;
    while(!q.isEmpty()) {
      int[] cur = q.poll();

      for(int k = 0; k < 4; k++) {
        int x = cur[0] + dx[k];
        int y = cur[1] + dy[k];
        if(x < 0 || x > 4 || y < 0 || y > 4) continue;
        if(!temp[x][y]) continue;
        if(visited[x][y]) continue;
        visited[x][y] = true;
        memberCount++;
        YCount += arr[x][y] ? 1 : 0;
        q.add(new int[]{x, y});
      }
    }

    if(memberCount >= 7 && YCount <= 3) {
      count++;
    }
  }
}