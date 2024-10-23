import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int sum = 0;
    int min = Integer.MAX_VALUE;
    for(int i = 0; i < 7; i++) {
      int num = Integer.parseInt(br.readLine());
      if(num % 2 != 0) {
        sum += num;
        min = Math.min(min, num);
      }
    }

    if(sum == 0) {
      bw.write("-1");
    } else {
      bw.write(sum + "\n");
      bw.write(min + "");
    }

    bw.flush();
    bw.close();

  }
}