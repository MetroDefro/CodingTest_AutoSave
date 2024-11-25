import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());
    List<Integer>[] nodes = new List[N + 1];
    for(int i = 1; i <= N; i++) {
      nodes[i] = new ArrayList<>();
    }
    for(int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      nodes[a].add(b);
      nodes[b].add(a);
    }

    Queue<Integer> q = new PriorityQueue<>();
    q.add(R);

    while(!q.isEmpty()) {
      int cur = q.poll();
      for(int i : nodes[cur]) {
        nodes[i].remove((Integer) cur);
        q.add(i);
      }
    }
    int[] size = new int[N + 1];
    dfs(nodes, size, R);

    while (Q-- >0) {
      bw.write(size[Integer.parseInt(br.readLine())] + "\n");
    }

    bw.flush();
    bw.close();
  }

  private static int dfs(List<Integer>[] nodes, int[] size, int cur) {
    size[cur] = 1;
    for(int i : nodes[cur]) {
      size[cur] += dfs(nodes, size, i);
    }
    return size[cur];
  }
}