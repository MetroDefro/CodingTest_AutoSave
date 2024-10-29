import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      long N = Long.parseLong(br.readLine());
      long low = 1;
      long high = Integer.MAX_VALUE;
      long max = 0;
      while (low <= high) {
        long mid = (low + high) / 2;
        long num = mid * (mid + 1) / 2;

        if(num <= N){
          max = Math.max(max, mid);
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }

      bw.write(max + "\n");

    }
    bw.flush();
    bw.close();

  }
}