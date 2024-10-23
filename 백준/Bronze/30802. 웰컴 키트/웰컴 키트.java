import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] inputs = br.readLine().split(" ");
    int[] sizes = new int[6];
    for (int i = 0; i < 6; i++) {
      sizes[i] = Integer.parseInt(inputs[i]);
    }
    inputs = br.readLine().split(" ");
    int T = Integer.parseInt(inputs[0]);
    int P = Integer.parseInt(inputs[1]);

    int countT = 0;
    for(int i = 0; i < 6; i++) {
      if(sizes[i] == 0)
        continue;
      countT += (sizes[i] - 1) / T + 1;
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(countT + "\n");
    bw.write(N / P + " " + N % P);

    bw.flush();
    bw.close();

  }
}