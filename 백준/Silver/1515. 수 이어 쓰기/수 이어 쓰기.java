import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    int prev = input.charAt(0) - '0';
    if(prev == 0) {
      prev = 10;
    }

    for(int i = 1; i < input.length(); i++) {
      Integer current = input.charAt(i) - '0';
      Integer num = prev + 1;

      while(true) {
        if(num.toString().contains(current.toString())) {
          prev = num;
          int index = num.toString().indexOf(current.toString()) + 1;
          for(int j = i + 1; index < num.toString().length() && j < input.length(); index++) {
            if(num.toString().charAt(index) == input.charAt(j)) {
              i = j;
              j++;
            }
          }

          break;
        }
        num++;
      }
    }

    System.out.println(prev);

  }
}
