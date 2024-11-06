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
import org.w3c.dom.Node;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int X = Integer.parseInt(st.nextToken());

    List<Integer>[] graph = new List[N + 1];
    for(int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }
    while (M-- > 0) {
      st = new StringTokenizer(br.readLine());
      graph[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
    }

    Queue<Node> queue = new PriorityQueue<>();
    int[] dist = new int[N + 1];
    boolean[] visited = new boolean[N + 1];

    for(int i = 1; i <= N; i++) {
      dist[i] = Integer.MAX_VALUE;
    }

    queue.add(new Node(X, 0));
    dist[X] = 0;
    visited[X] = true;

    while (!queue.isEmpty()) {
      Node node = queue.poll();

      for (int i = 0; i < graph[node.index].size(); i++) {
        if(!visited[graph[node.index].get(i)]) {
          visited[graph[node.index].get(i)] = true;
          if (dist[graph[node.index].get(i)] > node.dist + 1) {
            dist[graph[node.index].get(i)] = node.dist + 1;
          }
          queue.add(new Node(graph[node.index].get(i), node.dist + 1));
        }
      }
    }
    int count = -1;
    for(int i = 1; i <= N; i++) {
      if(dist[i] == K){
        bw.write(i + "\n");
        count++;
      }
    }
    if(count == -1){
      bw.write(-1 + "");
    }

    bw.flush();
    bw.close();
  }

  static class Node implements Comparable<Node> {
    int index;
    int dist;

    public Node(int index, int dist) {
      this.index = index;
      this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
      return this.dist - o.dist;
    }
  }
}