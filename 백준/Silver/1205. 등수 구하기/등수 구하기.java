import java.util.Scanner;

class Main {

  public static void main(String[] args) {

    Scanner cs = new Scanner(System.in);

    String[] input = cs.nextLine().split(" ");
    int N = Integer.parseInt(input[0]);
    long score = Long.parseLong(input[1]);
    int P = Integer.parseInt(input[2]);

    if(N == 0) {
      System.out.println(1);
      return;
    }

    input = cs.nextLine().split(" ");
    int countHighScore = 0;
    int countSameScore = 0;
    for (int i = 0; i < N; i++) {
      if(Integer.parseInt(input[i]) > score) {
        countHighScore++;
      } else if(Integer.parseInt(input[i]) == score) {
        countSameScore++;
      }
    }

    if(countHighScore + countSameScore >= P) {
      System.out.println(-1);
    } else {
      System.out.println(countHighScore + 1);
    }

  }

}