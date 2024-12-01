import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  private static int[] arr = new int[10];
  private static int max = 0;
  private static int[][] map =
      { { 0, 1, -1 },
          { 2, 2, -1 },
          { 4, 3, -1 },
          { 6, 4, -1 },
          { 8, 5, -1 },
          { 10, 6, 22 },
          { 12, 7, -1 },
          { 14, 8, -1 },
          { 16, 9, -1 },
          { 18, 10, -1 },
          { 20, 11, 29 },
          { 22, 12, -1 },
          { 24, 13, -1 },
          { 26, 14, -1 },
          { 28, 15, -1 },
          { 30, 16, 26 },
          { 32, 17, -1 },
          { 34, 18, -1 },
          { 36, 19, -1 },
          { 38, 20, -1 },
          { 40, 21, -1 },
          { 0, 21, -1 },
          { 13, 23, -1 },
          { 16, 24, -1 },
          { 19, 25, -1 },
          { 25, 31, -1 },
          { 28, 27, -1 },
          { 27, 28, -1 },
          { 26, 25, -1 },
          { 22, 30, -1 },
          { 24, 25, -1 },
          { 30, 32, -1 },
          { 35, 20, -1 } };

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    for(int i = 0; i < 10; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    dfs(0, new int[4], new boolean[33], 0);
    bw.write(max + "");

    bw.flush();
    bw.close();
  }

  private static void dfs(int sum, int[] index, boolean[] isHave, int depth) {
    if(depth == 10) {
      max = Math.max(max, sum);
      return;
    }

    for(int i = 0; i < 4; i++) {
      if(index[i] == 21) continue;

      int temp = index[i];
      int cur = temp;
      int count = arr[depth];

      if(map[cur][2] != -1) {
        cur = map[cur][2];
        count--;
      }

      while (count-- > 0) {
        cur = map[cur][1];
      }

      if(isHave[cur] && cur != 21) continue;

      isHave[temp] = false;
      isHave[cur] = true;
      index[i] = cur;

      dfs(sum + map[index[i]][0], index, isHave, depth + 1);

      isHave[temp] = true;
      isHave[cur] = false;
      index[i] = temp;
    }
  }
}