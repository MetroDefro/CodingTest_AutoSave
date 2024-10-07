import java.util.Scanner;

class Main {

  public static void main(String[] args) {

    Scanner cs = new Scanner(System.in);

    String[] input = cs.nextLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int K = Integer.parseInt(input[1]);

    int KIndex = 0;
    int[][] nation = new int[N][4];
    int count = 0;
    for (int i = 0; i < N; i++) {
      input = cs.nextLine().split(" ");
      for (int j = 0; j < 4; j++) {
        nation[i][j] = Integer.parseInt(input[j]);
      }
      if(nation[i][0] == K) {
        KIndex = i;
      }
    }

    for(int i = 0; i < N; i++) {
      if(KIndex == i) {
        continue;
      }
      for(int j = 1; j < 4; j++) {
        if(nation[i][j] > nation[KIndex][j]) {
          count++;
          break;
        } else if(nation[i][j] < nation[KIndex][j]) {
          break;
        }
      }
    }

    System.out.println(count + 1);

  }

}