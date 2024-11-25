import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int[] arr = new int[N];
    int[] flutes = new int[10];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int left = 0, max = 0;
    for(int i = 0; i < N; i++) {
      flutes[arr[i]]++;

      while (true) {
        int sum = 0;
        for (int j = 1; j <= 9; j++) {
          if (flutes[j] > 0) {
            sum++;
          }
        }

        if (sum <= 2)
          break;

        flutes[arr[left]]--;
        left++;
      }

      max = Math.max(max, i - left + 1);
    }

    bw.write(max + "\n");
    bw.flush();
    bw.close();
  }
}