import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    String[] input = bf.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int X = Integer.parseInt(input[1]);
    input = bf.readLine().split(" ");

    int[] visitants = new int[N];
    int max = 0;
    int sum = 0;
    int count = 1;

    for(int i=0; i<N; i++) {
      visitants[i] = Integer.parseInt(input[i]);
      sum += visitants[i];
      if(i < X - 1) {
        continue;
      }
      if(i >= X) {
        sum -= visitants[i - X];
      }

      if(sum > max) {
        max = sum;
        count = 1;
      } else if(sum == max) {
        count++;
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    if(max == 0) {
      bw.write("SAD");
    } else {
      bw.write(max + "\n" + count);
    }

    bw.flush();
    bw.close();

  }

}