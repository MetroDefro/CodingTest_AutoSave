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

    int[] arr = new int[5];
    for(int i = 0; i < 5; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr);

    int aver = 0;
    int middle = 0;
    for(int i = 0; i < 5; i++) {
      if(i == 2) {
        middle = arr[i];
      }
      aver += arr[i];
    }

    aver /= 5;

    bw.write(aver +"\n");
    bw.write(middle +"");

    bw.flush();
    bw.close();

  }
}