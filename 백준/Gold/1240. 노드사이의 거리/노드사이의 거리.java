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

    String[] inputs = br.readLine().split(" ");
    int N = Integer.parseInt(inputs[0]);
    int M = Integer.parseInt(inputs[1]);
    List<int[]>[] list = new ArrayList[N+1];
    for(int i = 1; i <= N; i++){
      list[i] = new ArrayList<>();
    }
    for (int i = 0; i < N - 1; i++) {
      inputs = br.readLine().split(" ");
      list[Integer.parseInt(inputs[0])].add(new int[]{Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2])});
      list[Integer.parseInt(inputs[1])].add(new int[]{Integer.parseInt(inputs[0]), Integer.parseInt(inputs[2])});
    }

    for (int i = 0; i < M; i++) {
      inputs = br.readLine().split(" ");
      int startNode = Integer.parseInt(inputs[0]);
      int endNode = Integer.parseInt(inputs[1]);
      boolean[] visited = new boolean[N + 1];
      visited[startNode] = true;

      Queue<int[]> queue = new LinkedList<>();
      for(int j = 0; j < list[startNode].size(); j++) {
        queue.add(list[startNode].get(j));
      }

      while (!queue.isEmpty()) {
        int[] node = queue.poll();
        if(node[0] == endNode) {
          bw.write(node[1] + "\n");
          break;
        }

        for(int j = 0; j < list[node[0]].size(); j++) {
          if(!visited[list[node[0]].get(j)[0]]) {
            visited[list[node[0]].get(j)[0]] = true;
            queue.add(new int[]{list[node[0]].get(j)[0], node[1] + list[node[0]].get(j)[1]});
          }
        }
      }
    }

    bw.flush();
    bw.close();
  }
}