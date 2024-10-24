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

    int[] arr = new int[20];
    for(int i = 0; i < 20; i++){
      arr[i] = i + 1;
    }
    for(int i = 0; i < 10; i++) {
      String[] inputs = br.readLine().split(" ");
      int a = Integer.parseInt(inputs[0]);
      int b = Integer.parseInt(inputs[1]);
      int j = 0;
      while (a + j < b - j) {
        int temp = arr[a + j - 1];
        arr[a + j - 1] = arr[b - j - 1];
        arr[b - j - 1] = temp;
        j++;
      }
    }

    for(int i = 0; i < 20; i++) {
      bw.write(arr[i] + " ");
    }

    bw.flush();
    bw.close();

  }
}