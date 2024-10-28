import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    Stack<Long[]> stack = new Stack<>();
    long count = 0;
    stack.push(new Long[]{Long.parseLong(br.readLine()), 1L});
    for(int i = 1; i < N; i++) {
      long height = Long.parseLong(br.readLine());
      while (!stack.isEmpty() && stack.peek()[0] <= height) {
        count += i - stack.pop()[1];
      }
      stack.push(new Long[]{height, (long)i + 1});
    }
    while(!stack.isEmpty()) {
      count += N - stack.pop()[1];
    }

    bw.write(count + "");

    bw.flush();
    bw.close();

  }
}