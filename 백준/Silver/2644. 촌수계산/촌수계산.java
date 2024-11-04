import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    String[] inputs = br.readLine().split(" ");
    int start = Integer.parseInt(inputs[0]);
    int end = Integer.parseInt(inputs[1]);
    int M = Integer.parseInt(br.readLine());
    List<Integer>[] list = new ArrayList[N+1];
    for(int i = 1; i <= N; i++){
      list[i] = new ArrayList<>();
    }
    for (int i = 0; i < M; i++) {
      inputs = br.readLine().split(" ");
      list[Integer.parseInt(inputs[0])].add(Integer.parseInt(inputs[1]));
      list[Integer.parseInt(inputs[1])].add(Integer.parseInt(inputs[0]));
    }

    boolean[] visited = new boolean[N + 1];
    visited[start] = true;

    Queue<int[]> queue = new LinkedList<>();
    for(int j = 0; j < list[start].size(); j++) {
      queue.add(new int[]{list[start].get(j), 1});
    }

    while (!queue.isEmpty()) {
      int[] node = queue.poll();
      if(node[0] == end) {
        bw.write(node[1] + "\n");
        bw.flush();
        bw.close();
        return;
      }

      for(int j = 0; j < list[node[0]].size(); j++) {
        if(!visited[list[node[0]].get(j)]) {
          visited[list[node[0]].get(j)] = true;
          queue.add(new int[]{list[node[0]].get(j), node[1] + 1});
        }
      }
    }

    bw.write("-1\n");
    bw.flush();
    bw.close();


  }
}