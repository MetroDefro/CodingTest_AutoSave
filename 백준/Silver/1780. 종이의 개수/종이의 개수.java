import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  private static int[][] matrix;
  private static int[] allCounts = new int[3];
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    matrix = new int[N][N];
    for(int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    divide(0, 0, N);
    bw.write(allCounts[0] + "\n");
    bw.write(allCounts[1] + "\n");
    bw.write(allCounts[2] + "\n");

    bw.flush();
    bw.close();
  }

  private static void divide(int x, int y, int n) {
    int[] counts = new int[3];
    for(int i = x; i < x + n; i++) {
      for(int j = y; j < y + n; j++) {
        if(matrix[i][j] == -1) {
          counts[0]++;
        } else if(matrix[i][j] == 0) {
          counts[1]++;
        } else if(matrix[i][j] == 1) {
          counts[2]++;
        }
      }
    }

    if(counts[0] == n * n) {
      allCounts[0]++;
    } else if(counts[1] == n * n) {
      allCounts[1]++;
    } else if(counts[2] == n * n) {
      allCounts[2]++;
    } else {
      for(int i = x; i < x + n; i+= n / 3) {
        for(int j = y; j < y + n; j+= n / 3) {
          divide(i, j, n / 3);
        }
      }
    }
  }
}