import java.util.Scanner;

class Main {

  public static void main(String[] args) {

    Scanner cs = new Scanner(System.in);

    while (true) {
      String input = cs.nextLine();

      if(input.equals("end")) {
        break;
      }

      System.out.print("<" + input + "> ");

      if(!input.contains("a") && !input.contains("e") && !input.contains("i") && !input.contains("o") && !input.contains("u")) {
        System.out.println("is not acceptable.");
        continue;
      }

      int countConsonants = 0;
      int countVowel = 0;
      char previous = input.charAt(0);
      for(int i = 0; i < input.length(); i++) {
        if(input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' ||input.charAt(i) == 'o' || input.charAt(i) == 'u') {
          countVowel++;
          countConsonants = 0;
        } else {
          countConsonants++;
          countVowel = 0;
        }

        if(countConsonants >= 3 || countVowel >= 3) {
          System.out.println("is not acceptable.");
          break;
        }

        if(i != 0 && previous == input.charAt(i)) {
          if(previous != 'e' && previous != 'o') {
            System.out.println("is not acceptable.");
            break;
          }
        }

        previous = input.charAt(i);

        if(i == input.length() - 1) {
          System.out.println("is acceptable.");
        }
      }

    }

  }

}