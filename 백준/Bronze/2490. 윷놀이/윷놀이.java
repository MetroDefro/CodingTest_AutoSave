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

    for(int i = 0; i < 3; i++) {
      String[] inputs = br.readLine().split(" ");
      int count = 0;
      for(int j = 0; j < 4; j++) {
        if(inputs[j].equals("0")) {
          count++;
        }
      }
      if(count == 1) {
        bw.write("A\n");
      } else if(count == 2) {
        bw.write("B\n");
      } else if(count == 3) {
        bw.write("C\n");
      } else if(count == 4) {
        bw.write("D\n");
      } else {
        bw.write("E\n");
      }
    }

    bw.flush();
    bw.close();

  }
}