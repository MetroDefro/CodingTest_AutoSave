import java.util.Scanner;

class Main {

  public static void main(String[] args) {

    Scanner cs = new Scanner(System.in);

    int N = Integer.parseInt(cs.nextLine());

    System.out.println(N % 2 == 0 ? "CY" : "SK");

  }

}