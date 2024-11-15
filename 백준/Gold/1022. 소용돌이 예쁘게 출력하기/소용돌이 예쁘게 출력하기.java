import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int r1 = Integer.parseInt(st.nextToken());
    int c1 = Integer.parseInt(st.nextToken());
    int r2 = Integer.parseInt(st.nextToken());
    int c2 = Integer.parseInt(st.nextToken());

    int max = Math.max(getNum(r1, c1), Math.max(getNum(r1, c2), Math.max(getNum(r2, c1), getNum(r2, c2))));
    int maxLength = String.valueOf(max).length();
    for(int r = r1; r <= r2; r++) {
      for(int c = c1; c <= c2; c++) {
        int num = getNum(r, c);

        int count = maxLength - String.valueOf(num).length();
        while(count-- > 0) {
          bw.write(" ");
        }
        bw.write(num + " ");
      }
      bw.newLine();
    }

    bw.flush();
    bw.close();
  }

  private static int getNum(int r, int c) {
    int l = Math.max(Math.abs(r), Math.abs(c));
    int start = (2 * l - 1) * (2 * l - 1) + 1;
    int num = 0;
    if(-l <= r && r < l && c == l) {
      num = start + l - r - 1;
    } else if(r == -l && -l <= c && c < l) {
      num = (start + (2 * l)) + l - c - 1;
    } else if(-l < r && r <= l && c == -l) {
      num = (start + (2 * l) * 2) + l + r - 1;
    } else if(r == l && -l < c && c <= l) {
      num = (start + (2 * l) * 3) + l + c - 1;
    }
    if(r == 0 && c == 0) {
      num = 1;
    }
    return num;
  }
}