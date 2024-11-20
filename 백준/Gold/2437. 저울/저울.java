import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for(int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    int num = 0;
    while (true) {
      num++;

      int sum = 0;
      for(int j = N - 1; j >= 0; j--) {
        if(num - sum >= arr[j]) {
          sum += arr[j];
        }
        if(sum == num) {
          break;
        }
      }
      if(sum != num) {
        bw.write(num + "\n");
        break;
      }
    }


    bw.flush();
    bw.close();
  }

}