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

    int K = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int W = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());
    boolean[][] matrix = new boolean[H][W];
    for(int i = 0; i < H; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < W; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken()) == 1;
      }
    }

    int[] dHH = {1, 2, 2, 1, -1, -2, -2, -1};
    int[] dWH = {-2, -1, 1, 2, -2, -1, 1, 2};
    int[] dHM = {1, -1, 0, 0};
    int[] dWM = {0, 0, 1, -1};

    int[][][] dist = new int[H][W][K + 1];
    for(int i = 0; i < H; i++) {
      for(int j = 0; j < W; j++) {
        for(int k = 0; k <= K; k++) {
          dist[i][j][k] = -1;
        }
      }
    }

    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{0, 0, 0, 0});

    int min = Integer.MAX_VALUE;
    while(!q.isEmpty()) {
      int[] cur = q.poll();

      if(cur[0] == H - 1 && cur[1] == W - 1) {
        min = Math.min(min, cur[3]);
      }

      if(cur[2] < K) {
        for(int i = 0; i < 8; i++) {
          int h = cur[0] + dHH[i];
          int w = cur[1] + dWH[i];
          if(h < 0 || h >= H || w < 0 || w >= W) continue;
          if(matrix[h][w]) continue;
          if(dist[h][w][cur[2]+1] != -1 && dist[h][w][cur[2]+1] <= cur[3] + 1) continue;
          dist[h][w][cur[2]+1] = cur[3] + 1;
          q.offer(new int[]{h, w, cur[2]+1, cur[3] + 1});
        }
      }

      for(int i = 0; i < 4; i++) {
        int h = cur[0] + dHM[i];
        int w = cur[1] + dWM[i];
        if(h < 0 || h >= H || w < 0 || w >= W) continue;
        if(matrix[h][w]) continue;
        if(dist[h][w][cur[2]] != -1 && dist[h][w][cur[2]] <= cur[3] + 1) continue;
        dist[h][w][cur[2]] = cur[3] + 1;
        q.offer(new int[]{h, w, cur[2], cur[3] + 1});
      }
    }

    if(min != Integer.MAX_VALUE) {
      bw.write(min + "\n");
    } else {
      bw.write("-1\n");
    }

    bw.flush();
    bw.close();
  }

}