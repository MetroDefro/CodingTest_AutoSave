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
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for(int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int S = Integer.parseInt(br.readLine());

    int start = 0;
    while(S > 0 && start < N) {
      int index = start;
      for(int j = start + 1; j < N && j <= start + S; j++) {
        if(arr[j] > arr[index]) {
          index = j;
        }
      }
      for(int j = index; j > start; j--) {
        int temp = arr[j];
        arr[j] = arr[j - 1];
        arr[j - 1] = temp;
      }

      S -= (index - start);
      start++;
    }

    for(int i = 0; i < N; i++) {
      bw.write(arr[i] + " ");
    }

    bw.flush();
    bw.close();
  }

}