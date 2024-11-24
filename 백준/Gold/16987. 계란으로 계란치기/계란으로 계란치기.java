import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  private static int max = 0;
  private static int[][] arr;
  private static int N;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    arr = new int[N][2];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }
    dfs(0, 0);
    bw.write(max + "");
    bw.flush();
    bw.close();
  }

  private static void dfs(int left, int count) {
    max = Math.max(max, count);
    if (left == N) {
      return;
    }
    if(arr[left][0] <= 0) {
      if(left < N - 1) {
        dfs(left + 1, count);
      }
      return;
    }
    for(int i = 0; i < N; i++) {
      if(i == left) continue;
      if(arr[i][0] <= 0) continue;
      arr[i][0] -= arr[left][1];
      arr[left][0] -= arr[i][1];
      dfs(left + 1, count + (arr[i][0] <= 0 ? 1 : 0) + (arr[left][0] <= 0 ? 1 : 0));
      arr[i][0] += arr[left][1];
      arr[left][0] += arr[i][1];
    }
  }
}