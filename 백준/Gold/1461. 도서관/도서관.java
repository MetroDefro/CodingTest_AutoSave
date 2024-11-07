import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());

    Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    Queue<Integer> nq = new PriorityQueue<>(Comparator.reverseOrder());

    for(int i = 0; i < N; i++) {
      int pos = Integer.parseInt(st.nextToken());
      if(pos > 0) pq.add(pos);
      else nq.add(Math.abs(pos));
    }

    int count = 0;
    boolean first = true;
    while(!pq.isEmpty() || !nq.isEmpty()) {
      Queue<Integer> q;
      if(pq.isEmpty()) q = nq;
      else if(nq.isEmpty()) q = pq;
      else q = pq.peek() > nq.peek() ? pq : nq;

      if(first) {
        count += q.poll();
        first = false;
      } else {
        count += q.poll() * 2;
      }

      for(int i = 0; i < M - 1; i++) {
        q.poll();
        if(q.isEmpty()) {
          break;
        }
      }
    }

    bw.write(count + "\n");
    bw.flush();
    bw.close();
  }
}