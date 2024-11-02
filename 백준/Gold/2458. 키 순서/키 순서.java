import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  private static int N = 0;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] inputs = br.readLine().split(" ");
    N = Integer.parseInt(inputs[0]);
    int M = Integer.parseInt(inputs[1]);
    boolean[][] arr = new boolean[N + 1][N + 1];
    for (int i = 0; i < M; i++) {
      inputs = br.readLine().split(" ");
      arr[Integer.parseInt(inputs[0])][Integer.parseInt(inputs[1])] = true;
    }

    // b -> c 자신으로부터 앞으로
    // a -> b 자신으로부터 뒤로

    int[] counts = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      boolean[] visited = new boolean[N + 1];
      visited[i] = true;
      counts[i] = 1;
      dfsBack(arr, i, visited, counts, i);
      dfsFront(arr, i, visited, counts, i);
    }

    int count = 0;
    for(int i = 1; i <= N; i++) {
      if(counts[i] == N) {
        count++;
      }
    }
    bw.write(count + "\n");

    bw.flush();
    bw.close();

  }

  private static void dfsBack(boolean[][] arr, int i, boolean[] visited, int[] counts, int cur) {
    for (int j = 1; j <= N; j++) {
      if (arr[i][j] && !visited[j]) {
        visited[j] = true;
        counts[cur]++;
        dfsBack(arr, j, visited, counts, cur);
      }
    }
  }

  private static void dfsFront(boolean[][] arr, int i, boolean[] visited, int[] counts, int cur) {
    for (int j = 1; j <= N; j++) {
      if (arr[j][i] && !visited[j]) {
        visited[j] = true;
        counts[cur]++;
        dfsFront(arr, j, visited, counts, cur);
      }
    }
  }
}