import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    List<int[]> flowers = new ArrayList();
    while (n-- > 0) {
      String[] inputs = br.readLine().split(" ");
      flowers.add(new int[]{
          Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]), Integer.parseInt(inputs[3])});
    }

    flowers.sort(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if(o1[2] == o2[2]) {
          return o2[3] - o1[3];
        }
        return o2[2] - o1[2];
      }
    });

    int prevMonth = 3;
    int prevDay = 1;
    int count = 0;
    while (prevMonth < 12) {
      for(int i = 0; i < flowers.size(); i++) {
        if(prevMonth > flowers.get(i)[0] || (prevMonth == flowers.get(i)[0] && prevDay >= flowers.get(i)[1])) {
          count++;
          prevMonth = flowers.get(i)[2];
          prevDay = flowers.get(i)[3];
          flowers.remove(flowers.get(i));
          break;
        }
        if(i == flowers.size() - 1) {
          count = 0;
        }
      }
      if(count == 0 || (prevMonth < 12 && flowers.isEmpty())) {
        count = 0;
        break;
      }
    }

    bw.write(count + "\n");

    bw.flush();
    bw.close();

  }
}