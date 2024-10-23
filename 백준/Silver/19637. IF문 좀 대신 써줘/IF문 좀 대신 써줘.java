import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");
    int N = Integer.parseInt(inputs[0]);
    int M = Integer.parseInt(inputs[1]);

    String[][] ranks = new String[N][2];
    for(int i = 0; i < N; i++) {
      inputs = br.readLine().split(" ");
      ranks[i][0] = inputs[0];
      ranks[i][1] = inputs[1];
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for(int i = 0; i < M; i++) {
      int power = Integer.parseInt(br.readLine());

      int low = 0;
      int high = N - 1;
      while(low <= high) {
        int mid = (low + high) / 2;
        int midInt = Integer.parseInt(ranks[mid][1]);
        if(power <= midInt) {
          high = mid - 1;
        } else if(power > midInt) {
          low = mid + 1;
        }
      }

      bw.write(ranks[low][0] + "\n");

    }

    bw.flush();
    bw.close();

  }
}
