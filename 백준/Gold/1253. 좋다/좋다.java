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

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for(int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);
    int count = getCount(N, arr);

    bw.write(count + "\n");
    bw.flush();
    bw.close();
  }

  private static int getCount(int N, int[] arr) {
    int count = 0;
    for(int i = 0; i < N; i++) {
      if(twoPointer(arr, i, N, arr[i])) {
        count++;
      }
    }
    return count;
  }

  private static boolean twoPointer(int[] arr, int i, int n, int num) {
    int start = 0;
    int end = n - 1;
    while(start < end) {
      int sum = arr[start] + arr[end];
      if(sum == num) {
        if(start == i) {
          start++;
        } else if(end == i) {
          end--;
        } else {
          return true;
        }
      }
      if(sum > num) {
        end--;
      } else if(sum < num) {
        start++;
      }
    }
    return false;
  }
}