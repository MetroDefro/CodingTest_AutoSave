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

    long N = Long.parseLong(br.readLine());
    Stack<Long[]> stack = new Stack<>();
    long count = 0;
    while (N-- > 0) {
      long height = Long.parseLong(br.readLine());
      long curCount = 1;
      while (!stack.isEmpty() && height >= stack.peek()[0]) {
        count += stack.peek()[1];
        if(height == stack.peek()[0]) {
          curCount += stack.peek()[1];
        }
        stack.pop();
      }
      if(!stack.isEmpty()) {
        count ++;
      }
      stack.push(new Long[]{height, curCount});
    }

    bw.write(count + "\n");

    bw.flush();
    bw.close();

  }
}