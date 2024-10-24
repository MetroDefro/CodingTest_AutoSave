import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] inputs = br.readLine().split(" ");
    int A = Integer.parseInt(inputs[0]);
    int B = Integer.parseInt(inputs[1]);

    int bigger = Math.max(A, B);
    int smaller = Math.min(A, B);

    if(bigger - smaller > 1) {
      bw.write(bigger - smaller - 1 +"\n");
    } else {
      bw.write(0 + "\n");
    }

    for(int i = smaller + 1; i < bigger; i++) {
      bw.write(i + " ");
    }

    bw.flush();
    bw.close();

  }
}