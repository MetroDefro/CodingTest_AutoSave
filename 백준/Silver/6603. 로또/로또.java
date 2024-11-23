import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  private static int[] temp = new int[6];
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] line = br.readLine().split(" ");
    do {
      int[] arr = new int[Integer.parseInt(line[0])];
      for (int i = 0; i < Integer.parseInt(line[0]); i++) {
        arr[i] = Integer.parseInt(line[i + 1]);
      }
      Arrays.sort(arr);
      dfs(arr, -1, 0, bw);
      bw.write("\n");
      line = br.readLine().split(" ");
    } while (!"0".equals(line[0]));

    bw.flush();
    bw.close();
  }

  private static void dfs(int[] arr, int prev, int depth, BufferedWriter bw) throws IOException {
    if(depth == 6) {
      for(int i = 0; i < 6; i++) {
        bw.write(temp[i] + " ");
      }
      bw.write("\n");
      return;
    }

    for(int i = prev + 1; i < arr.length; i++) {
      temp[depth] = arr[i];
      dfs(arr, i,depth + 1, bw);
    }
  }
}