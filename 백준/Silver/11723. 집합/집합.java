import java.util.Scanner;

class Main {

  public static void main(String[] args) {

    Scanner cs = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(cs.nextLine());
    int S = 0;

    for (int i = 0; i < n; i++) {

      String[] input = cs.nextLine().split(" ");
      String command = input[0];
      int num = input.length > 1 ? Integer.parseInt(input[1]) : 0;

      switch (command) {
        case "add" -> S |= (1 << num);
        case "remove" -> S &= ~(1 << num);
        case "check" -> sb.append((S & (1 << num)) != 0 ? 1 : 0).append("\n");
        case "toggle" -> S ^= (1 << num);
        case "all" -> S = Integer.MAX_VALUE;
        case "empty" -> S = 0;
      }

    }

    System.out.println(sb);

  }

}