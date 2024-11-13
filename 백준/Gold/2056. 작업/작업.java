import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import org.w3c.dom.Node;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] dp = new int[N+1];
    int max = 0;
    for(int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int time = Integer.parseInt(st.nextToken());
      int length = Integer.parseInt(st.nextToken());
      if(length == 0) {
        dp[i] = time;
      }
      for(int j = 0; j < length; j++) {
        dp[i] = Math.max(dp[i], dp[Integer.parseInt(st.nextToken())] + time);
      }
      max = Math.max(max, dp[i]);
    }

    bw.write(max + "\n");

    bw.flush();
    bw.close();
  }
}