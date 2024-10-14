import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Main {

  public static void main(String[] args) {

    Scanner cs = new Scanner(System.in);

    int T = Integer.parseInt(cs.nextLine());
    for(int t=0; t<T; t++) {
      int N = Integer.parseInt(cs.nextLine());
      String[] input = cs.nextLine().split(" ");
      List<Integer>[] team = new ArrayList[201];
      for(int i=0;i<team.length;i++) {
        team[i] = new ArrayList<>();
      }
      int maxTeam = 0;

      List<Integer> scores = new LinkedList<>();
      int[] teamCount = new int[201];
      for(int i = 0; i < N; i++) {
        scores.add(Integer.parseInt(input[i]));
        teamCount[Integer.parseInt(input[i])]++;
      }
      scores.removeIf(score -> teamCount[score] < 6);

      for(int i = 0; i < scores.size(); i++) {
        team[scores.get(i)].add(i + 1);
        maxTeam = Math.max(maxTeam, scores.get(i));
      }

      int min = Integer.MAX_VALUE;
      int minIndex = 0;
      for(int i = 1; i <= maxTeam; i++) {
        if(team[i].isEmpty()) {
          continue;
        }
        int sum = 0;
        for(int j = 0; j < 4; j++) {
          sum += team[i].get(j);
        }
        if(min > sum) {
          min = sum;
          minIndex = i;
        } else if(sum == min) {
          minIndex = team[i].get(4) < team[minIndex].get(4) ? i : minIndex;
        }
      }

      System.out.println(minIndex);
    }
  }

}