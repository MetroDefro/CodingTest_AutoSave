import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    boolean[][] arr = new boolean[N][M];
    for(int i = 0; i < N; i++) {
      String line = br.readLine();
      for(int j = 0; j < M; j++) {
        arr[i][j] = line.charAt(j) == '1';
      }
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    int[][][] dist = new int[N][M][2];
    dist[0][0][0] = 1;
    dist[0][0][1] = 1;
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(0, 0, 0));

    while(!queue.isEmpty()) {
      Node node = queue.poll();
      if(node.x == N - 1 && node.y == M - 1) {
        bw.write(dist[node.x][node.y][node.z] + "\n");
        break;
      }
      for(int i = 0; i < 4; i++) {
        int x = node.x + dx[i];
        int y = node.y + dy[i];
        if(x < 0 || x >= N || y < 0 || y >= M) continue;
        if(arr[x][y]) {
          if(node.z == 1) continue;
          if(dist[x][y][1] > 0) continue;
          queue.add(new Node(x, y, 1));
          dist[x][y][1] = dist[node.x][node.y][node.z] + 1;
        } else {
          if(dist[x][y][node.z] > 0) continue;
          queue.add(new Node(x, y, node.z));
          dist[x][y][node.z] = dist[node.x][node.y][node.z] + 1;
        }
      }
      if(queue.isEmpty()) {
        bw.write(-1 + "\n");
      }
    }

    bw.flush();
    bw.close();
  }

  static class Node {
    int x, y, z;
    public Node(int x, int y, int z) {
      this.x = x;
      this.y = y;
      this.z = z;
    }
  }
}