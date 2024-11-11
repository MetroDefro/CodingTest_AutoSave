import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static int sum = 0;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      int N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] arr = new int[N + 1];
      for(int i = 1; i <= N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      sum = 0;
      boolean[] visited = new boolean[N + 1];
      boolean[] done = new boolean[N + 1];
      for(int i = 1; i <= N; i++) {
        if(!done[i]) {
          dfs(arr, visited, done, i);
        }
      }

      bw.write(N - sum + "\n");
    }
    bw.flush();
    bw.close();
  }

  private static void dfs(int[] arr, boolean[] visited, boolean[] done, int i) {
    visited[i] = true;
    int next = arr[i];
    if(done[next]) {
      done[i] = true;
      return;
    }
    if(visited[next]) {
      sum++;
      while (next != i) {
        sum++;
        next = arr[next];
      }
    } else dfs(arr, visited, done, next);
    done[i] = true;
  }
}