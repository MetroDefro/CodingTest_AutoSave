import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int index = -1;
    int number = -1;
    for(int i = 0; i < 3; i++) {
      try {
        String input = br.readLine();
        number = Integer.parseInt(input);
        index = i;
      } catch (NumberFormatException ignored) {

      }
    }

    int nextNum = number + 3 - index;

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    if(nextNum % 3 == 0) {
      bw.write("Fizz");
    }
    if(nextNum % 5 == 0) {
      bw.write("Buzz");
    }
    if(nextNum % 5 != 0 && nextNum % 3 != 0) {
      bw.write("" + nextNum);
    }

    bw.flush();
    bw.close();

  }
}