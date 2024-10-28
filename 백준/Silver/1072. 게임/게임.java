import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] inputs = br.readLine().split(" ");
    double x = Integer.parseInt(inputs[0]);
    double y = Integer.parseInt(inputs[1]);

    int goal = (int)(y * 100 / x);
    if(goal >= 99) {
      bw.write(-1 + "");
      bw.flush();
      bw.close();
      return;
    }

    goal++;

    int low = 0;
    int high = (int)x;
    while (low <= high) {
      int mid = (low + high) / 2;
      int winning = (int)((y + mid) * 100 / (x + mid));
      if(winning >= goal) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    bw.write(low + "");

    bw.flush();
    bw.close();

  }
}