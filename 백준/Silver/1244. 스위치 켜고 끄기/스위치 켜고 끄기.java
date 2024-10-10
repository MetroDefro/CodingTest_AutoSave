import java.util.Scanner;

class Main {

  public static void main(String[] args) {

    Scanner cs = new Scanner(System.in);

    int N = Integer.parseInt(cs.nextLine());
    String[] input = cs.nextLine().split(" ");
    boolean[] switched = new boolean[N];
    for(int i = 0; i<N; i++){
      switched[i] = input[i].equals("1");
    }

    int studentCount = Integer.parseInt(cs.nextLine());
    for(int i = 0; i < studentCount; i++) {
      input = cs.nextLine().split(" ");
      int studentNum = Integer.parseInt(input[1]);
      if(input[0].equals("1")) {
        int index = studentNum;
        while (index <= N) {
          switched[index - 1] = !switched[index - 1];
          index += studentNum;
        }
      } else if(input[0].equals("2")) {
        switched[studentNum - 1] = !switched[studentNum - 1];
        int index = 1;
        while (studentNum + index - 1 < N && studentNum - index - 1 >= 0) {
          if(switched[studentNum + index - 1] != switched[studentNum - index - 1]) {
            break;
          }
          switched[studentNum + index - 1] = !switched[studentNum + index - 1];
          switched[studentNum - index - 1] = !switched[studentNum - index - 1];
          index++;
        }
      }
    }

    for(int i = 1; i<=N; i++){
      System.out.print((switched[i - 1] ? 1 : 0) + " ");
      if(i % 20 == 0) {
        System.out.println();
      }
    }

  }

}