import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int count = 0;
    while (true) {
      count++;
      int N = Integer.parseInt(br.readLine());
      if (N == 0)
        break;

      int[][] matrix = new int[N][N];
      for (int i = 0; i < N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          matrix[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      Queue<Node> queue = new PriorityQueue<>();
      int[][] distance = new int[N][N];
      boolean[][] visited = new boolean[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          distance[i][j] = Integer.MAX_VALUE;
        }
      }

      queue.add(new Node(0, 0, matrix[0][0]));
      distance[0][0] = matrix[0][0];
      visited[0][0] = true;

      int[] addX = {1, -1, 0, 0};
      int[] addY = {0, 0, 1, -1};

      while (!queue.isEmpty()) {
        Node node = queue.poll();

        for (int j = 0; j < 4; j++) {
          int newX = node.x + addX[j], newY = node.y + addY[j];

          if (newX >= 0 && newY >= 0 && newX < N && newY < N) {
            if(!visited[newX][newY]) {
              visited[newX][newY] = true;
              if (distance[newX][newY] > node.dist + matrix[newX][newY]) {
                distance[newX][newY] = node.dist + matrix[newX][newY];
              }
              queue.add(new Node(newX, newY, distance[newX][newY]));
            }
          }
        }
      }
      bw.write("Problem " + count + ": " + distance[N - 1][N - 1] + "\n");
    }
    bw.flush();
    bw.close();
  }

  static class Node implements Comparable<Node> {
    int x;
    int y;
    int dist;

    public Node(int x, int y, int dist) {
      this.x = x;
      this.y = y;
      this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
      return this.dist - o.dist;
    }
  }
}