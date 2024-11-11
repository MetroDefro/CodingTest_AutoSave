import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());
    Deque<Character> d = new ArrayDeque<>();
    while (T-- > 0) {
      int N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      d.push(st.nextToken().charAt(0));
      for(int i = 1; i < N; i++) {
        char c = st.nextToken().charAt(0);
        if(d.getFirst() >= c) {
          d.addFirst(c);
        } else {
          d.addLast(c);
        }
      }
      StringBuilder sb = new StringBuilder();
      while(!d.isEmpty()) {
        sb.append(d.removeFirst());
      }
      bw.write(sb.toString() + "\n");
    }

    bw.flush();
    bw.close();
  }
}