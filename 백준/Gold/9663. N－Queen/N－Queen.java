import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  private static int N;
  private static int count;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    dfs(new boolean[N], new boolean[N * 2], new boolean[N * 2], 0);
    bw.write(count +"");

    bw.flush();
    bw.close();
  }

  private static void dfs(boolean[] visited1, boolean[] visited2, boolean[] visited3, int depth) {
    if(depth == N) {
      count++;
      return;
    }

    for(int i = 0; i < N; i++) {
      if(!visited1[i] && !visited2[i + depth] && !visited3[depth - i + N - 1]) {
        visited1[i] = true;
        visited2[i + depth] = true;
        visited3[depth - i + N - 1] = true;
        dfs(visited1, visited2, visited3, depth + 1);
        visited1[i] = false;
        visited2[i + depth] = false;
        visited3[depth - i + N - 1] = false;
      }
    }
  }
}