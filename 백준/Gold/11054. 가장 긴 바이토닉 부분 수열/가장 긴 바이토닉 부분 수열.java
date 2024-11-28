import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] dpUp = new int[N];
    int[] dpDown = new int[N];
    for (int i = 0; i < N; i++) {
      dpUp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
          dpUp[i] = Math.max(dpUp[i], dpUp[j] + 1);
        }
      }
    }

    for (int i = N - 1; i >= 0; i--) {
      dpDown[i] = 1;
      for (int j = N - 1; j > i; j--) {
        if (arr[j] < arr[i]) {
          dpDown[i] = Math.max(dpDown[i], dpDown[j] + 1);
        }
      }
    }

    int max = 0;
    for(int i = 0; i < N; i++) {
      max = Math.max(max, dpUp[i] + dpDown[i] - 1);
    }

    bw.write(max + "");
    bw.flush();
    bw.close();
  }
}