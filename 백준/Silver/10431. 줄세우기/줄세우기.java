import java.util.Arrays;
import java.util.Scanner;

class Main {

  public static void main(String[] args) {

    Scanner cs = new Scanner(System.in);

    int T = Integer.parseInt(cs.nextLine());

    for (int t = 0; t < T; t++) {

      int[] input = Arrays.stream(cs.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

      int count = 0;

      for (int i = 2; i <= 20; i++) {
        int height = input[i];
        for (int j = 1; j < i; j++) {
          if(height < input[j]) {
            for(int k = i; k > j; k--) {
              count++;
              input[k] = input[k - 1];
            }
            input[j] = height;
            break;
          }
        }
      }

      System.out.println(input[0] + " " + count);

    }

  }

}