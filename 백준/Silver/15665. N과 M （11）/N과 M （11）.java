import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  private static int N;
  private static int M;
  private static int[] arr;
  private static int[] temp;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N];
    temp = new int[M];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    dfs(0, bw);

    bw.flush();
    bw.close();
  }

  private static void dfs(int depth, BufferedWriter bw) throws IOException {
    if(depth == M) {
      for(int i = 0; i < M; i++) {
        bw.write(temp[i] + " ");
      }
      bw.write("\n");
      return;
    }

    int prev = 0;
    for(int i = 0; i < N; i++) {
      if(arr[i] != prev) {
        temp[depth] = arr[i];
        dfs(depth + 1, bw);
      }
      prev = arr[i];
    }
  }
}