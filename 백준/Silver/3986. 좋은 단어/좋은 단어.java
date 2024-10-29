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

    int count = 0;
    while (N-- > 0) {
      String s = br.readLine();
      Stack<Character> stack = new Stack<Character>();
      for(int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if(!stack.isEmpty() && stack.peek() == c) {
          stack.pop();
        } else {
          stack.push(c);
        }
      }
      if(stack.isEmpty()) {
        count++;
      }
    }

    bw.write(count + "\n");
    bw.flush();
    bw.close();

  }
}