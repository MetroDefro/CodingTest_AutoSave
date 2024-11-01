import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
  private static int count = 1;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] inputs = br.readLine().split(" ");
    int N = Integer.parseInt(inputs[0]);
    int M = Integer.parseInt(inputs[1]);
    int R = Integer.parseInt(inputs[2]);

    List<Integer>[] arr = new ArrayList[N + 1];
    for(int i = 1; i <= N; i++) {
      arr[i] = new ArrayList<>();
    }
    while (M-- > 0) {
      inputs = br.readLine().split(" ");

      arr[Integer.parseInt(inputs[0])].add(Integer.parseInt(inputs[1]));
      arr[Integer.parseInt(inputs[1])].add(Integer.parseInt(inputs[0]));
    }
    for(int i = 1; i <= N; i++) {
      arr[i].sort(Comparator.naturalOrder());
    }

    int[] order = new int[N + 1];
    bfs(arr, R, order);
    for(int i = 1; i <= N; i++) {
      bw.write(order[i] + "\n");
    }

    bw.flush();
    bw.close();

  }

  private static void bfs(List<Integer>[] arr, int r, int[] order) {
    boolean[] visited = new boolean[arr.length + 1];
    Queue<Integer> queue = new LinkedList<>();
    visited[r] = true;
    queue.add(r);
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      order[cur] = count++;
      for(int i : arr[cur]) {
        if (!visited[i]) {
          visited[i] = true;
          queue.add(i);
        }
      }
    }
  }
}