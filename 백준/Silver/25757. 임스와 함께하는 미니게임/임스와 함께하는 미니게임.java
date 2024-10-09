import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {

  public static void main(String[] args) {

    Scanner cs = new Scanner(System.in);

    String[] input = cs.nextLine().split(" ");
    int N = Integer.parseInt(input[0]);
    String game = input[1];

    Set<String> players = new HashSet<>();

    for(int i = 0; i < N; i++) {
      players.add(cs.nextLine());
    }

    switch (game) {
      case "Y" -> System.out.println(players.size());
      case "F" -> System.out.println(players.size() / 2);
      case "O" -> System.out.println(players.size() / 3);
    }

  }

}