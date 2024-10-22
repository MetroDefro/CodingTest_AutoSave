import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");
    String input = br.readLine();
    int N = Integer.parseInt(inputs[0]);
    int K = Integer.parseInt(inputs[1]);

    // H, P, E(Eat)
    char[] arr = new char[N];
    for(int i = 0; i < N; i++) {
      arr[i] = input.charAt(i);
    }

    int count = 0;
    for(int i = 0; i < N; i++) {
      if(arr[i] != 'P') {
        continue;
      }
      for(int j = Math.max(i - K, 0); j <= i + K && j >= 0 && j < N; j++) {
        if(arr[j] == 'H') {
          arr[j] = 'E';
          count++;
          break;
        }
      }
    }

    System.out.println(count);

  }
}
