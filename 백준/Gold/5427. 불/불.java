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

    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int C = Integer.parseInt(st.nextToken());
      int R = Integer.parseInt(st.nextToken());

      char[][] matrix = new char[R][C];

      Queue<int[]> qf = new LinkedList<>();
      Queue<int[]> qj = new LinkedList<>();
      int[][] distF = new int[R][C];
      int[][] distJ = new int[R][C];

      for(int i = 0; i < R; i++) {
        String input = br.readLine();
        for(int j = 0; j < C; j++) {
          distF[i][j] = -1;
          distJ[i][j] = -1;
          matrix[i][j] = input.charAt(j);
          if(matrix[i][j] == '@') {
            qj.add(new int[]{i, j});
            distJ[i][j] = 0;
          } else if(matrix[i][j] == '*') {
            qf.add(new int[]{i, j});
            distF[i][j] = 0;
          }
        }
      }

      int[] dx = {-1, 0, 1, 0};
      int[] dy = {0, -1, 0, 1};

      while(!qf.isEmpty()) {
        int[] cur = qf.poll();

        for(int i = 0; i < 4; i++) {
          int x = cur[0] + dx[i];
          int y = cur[1] + dy[i];
          if(x < 0 || x >= R || y < 0 || y >= C) continue;
          if(distF[x][y] >= 0 || matrix[x][y] == '#') continue;
          distF[x][y] = distF[cur[0]][cur[1]] + 1;
          qf.add(new int[]{x, y});
        }
      }

      while(!qj.isEmpty()) {
        int[] cur = qj.poll();

        boolean isEscape = false;
        for(int i = 0; i < 4; i++) {
          int x = cur[0] + dx[i];
          int y = cur[1] + dy[i];
          if(x < 0 || x >= R || y < 0 || y >= C) {
            isEscape = true;
            break;
          }
          if(distJ[x][y] >= 0 || matrix[x][y] == '#') continue;
          if(distF[x][y] != -1 && distF[x][y] <= distJ[cur[0]][cur[1]] + 1) continue;
          distJ[x][y] = distJ[cur[0]][cur[1]] + 1;
          qj.add(new int[]{x, y});
        }

        if(isEscape) {
          bw.write(distJ[cur[0]][cur[1]] + 1 + "\n");
          break;
        }

        if(qj.isEmpty()) {
          bw.write("IMPOSSIBLE\n");
          break;
        }
      }
    }

    bw.flush();
    bw.close();
  }
}