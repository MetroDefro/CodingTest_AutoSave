import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();
    String bomb = br.readLine();
    int length = bomb.length();

    Stack<Character> stack = new Stack<>();
    for(int i = 0; i < str.length(); i++){
      stack.push(str.charAt(i));
      if(stack.size() >= length){
        for(int j = length - 1; j >= 0; j--){
          if(stack.peek() == bomb.charAt(j)){
            stack.pop();
          } else {
            for(int k = j + 1; k < length; k++) {
              stack.push(bomb.charAt(k));
            }
            break;
          }
        }
      }
    }

    if(stack.isEmpty()){
      bw.write("FRULA");
    } else {
      for(Character ch : stack){
        bw.write(ch);
      }
    }

    bw.flush();
    bw.close();
  }
}