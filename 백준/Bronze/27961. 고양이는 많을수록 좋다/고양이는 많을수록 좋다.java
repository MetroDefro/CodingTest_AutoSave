import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    long N = Long.parseLong(br.readLine());

    long i = N == 0 ? 0 : 1, k = 1;
    for(; k * 2 <= N; i++, k*= 2){}
    bw.write(i + (N > k ? 1 : 0) + "\n");

    bw.flush();
    bw.close();
  }
}