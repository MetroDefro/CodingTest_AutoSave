import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {

  public static void main(String[] args) {

    Scanner cs = new Scanner(System.in);

    int N = Integer.parseInt(cs.nextLine());
    boolean[][] cookie = new boolean[N][N];

    for(int i = 0; i < N; i++) {
      String input = cs.nextLine();
      for(int j = 0; j < N; j++) {
        cookie[i][j] = input.charAt(j) == '*';
      }
    }

    int heartX = 0,heartY = 0;
    int leftHand = 0, rightHand = 0, waist = 0, leftFoot = 0, rightFoot = 0;

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        if(cookie[i][j]) {
          heartX = i + 1;
          heartY = j;
          break;
        }
      }
      if(heartX != 0)
        break;
    }

    for(int i = 0; i < N; i++) {
      if(cookie[heartX][i]) {
        leftHand = heartY - i;
        break;
      }
    }

    for(int i = N - 1; i >= 0; i--) {
      if(cookie[heartX][i]) {
        rightHand = i - heartY;
        break;
      }
    }

    for(int i = heartX + 1; i < N; i++) {
      if(!cookie[i][heartY]) {
        waist = i - heartX - 1;
        break;
      }
    }

    for(int i = heartX + waist + 1; i < N; i++) {
      if(!cookie[i][heartY - 1]) {
        break;
      }
      leftFoot++;
    }

    for(int i = heartX + waist + 1; i < N; i++) {
      if(!cookie[i][heartY + 1]) {
        break;
      }
      rightFoot++;
    }

    System.out.println((heartX + 1) + " " + (heartY + 1));
    System.out.println(leftHand + " " + rightHand + " " + waist + " " + leftFoot + " " + rightFoot);

  }

}