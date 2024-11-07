import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    List<Integer>[] graph = new List[N + 1];
    for(int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }
    while(M-- > 0) {
      st = new StringTokenizer(br.readLine());
      graph[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
    }

    int S = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    boolean[] visited = new boolean[N + 1];
    while(S-- > 0) {
      visited[Integer.parseInt(st.nextToken())] = true;
    }

    if(visited[1]) {
      bw.write("Yes\n");
    } else {
      Queue<Integer> q = new LinkedList<>();
      q.add(1);
      while(true) {
        int cur = q.poll();
        if(graph[cur].isEmpty()) {
          bw.write("yes\n");
          break;
        }
        for(int i = 0; i < graph[cur].size(); i++) {
          if(!visited[graph[cur].get(i)]) {
            visited[graph[cur].get(i)] = true;
            q.add(graph[cur].get(i));
          }
        }

        if(q.isEmpty()) {
          bw.write("Yes\n");
          break;
        }
      }
    }

    bw.flush();
    bw.close();
  }
}