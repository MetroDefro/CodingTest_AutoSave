import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    Deque<Integer> q = new LinkedList<>();
    while (N-- > 0) {
      String[] inputs = br.readLine().split(" ");
      String command = inputs[0];
      switch (command) {
        case "push" -> {
          int number = Integer.parseInt(inputs[1]);
          q.add(number);
        }
        case "pop" -> {
          if(q.isEmpty()) {
            bw.write("-1\n");
            continue;
          }
          int number = q.poll();
          bw.write(number + "\n");
        }
        case "size" -> {
          bw.write(q.size() + "\n");
        }
        case "empty" -> {
          bw.write((q.isEmpty() ? 1 : 0) + "\n");
        }
        case "front" -> {
          if(q.isEmpty()) {
            bw.write("-1\n");
            continue;
          }
          bw.write(q.peek() + "\n");
        }
        case "back" -> {
          if(q.isEmpty()) {
            bw.write("-1\n");
            continue;
          }
          bw.write(q.getLast() + "\n");
        }
      }
    }
    bw.flush();
    bw.close();

  }
}