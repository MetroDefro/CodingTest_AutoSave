import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    double[][] vertices = new double[N][2];
    double area = 0.0;
    for(int i = 0; i < N; i++) {
      String[] line = br.readLine().split(" ");
      vertices[i][0] = Integer.parseInt(line[0]);
      vertices[i][1] = Integer.parseInt(line[1]);

      if(i > 1) {
        area += (vertices[0][0] * vertices[i-1][1] +
            vertices[i-1][0] * vertices[i][1] +
            vertices[i][0] * vertices[0][1] -
            vertices[i-1][0] * vertices[0][1] -
            vertices[i][0] * vertices[i-1][1] -
            vertices[0][0] * vertices[i][1]) / 2.0;
      }
    }
    DecimalFormat df = new DecimalFormat("#.0");
    bw.write(df.format(Math.abs(area)));

    bw.flush();
    bw.close();

  }
}