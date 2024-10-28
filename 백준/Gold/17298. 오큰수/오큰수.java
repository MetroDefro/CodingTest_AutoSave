import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    String[] inputs = br.readLine().split(" ");
    Stack<Integer[]> stack = new Stack<>();
    int[] arr = new int[N];
    for(int i = 0; i < N; i++) {
      int num = Integer.parseInt(inputs[i]);
      while (!stack.isEmpty() && stack.peek()[0] < num) {
        arr[stack.pop()[1]] = num;
      }
      stack.push(new Integer[]{num, i});
    }
    while(!stack.isEmpty()) {
      arr[stack.pop()[1]] = -1;
    }

    for(int i = 0; i < N; i++) {
      bw.write(arr[i] + " ");
    }

    bw.flush();
    bw.close();

  }
}