import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int A = Integer.parseInt(br.readLine());
    int B = Integer.parseInt(br.readLine());
    int C = Integer.parseInt(br.readLine());


    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write((A + B - C) + "\n");
    bw.write(Integer.parseInt("" + A + B) - C + "\n");

    bw.flush();
    bw.close();

  }
}