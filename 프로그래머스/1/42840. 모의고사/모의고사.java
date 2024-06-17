import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] supozaScore = new int[3];
        int[][] supozaPattern = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        for(int i = 0; i < answers.length; i++) {
            for(int j = 0; j < 3; j++) {
                if(answers[i] == supozaPattern[j][i % supozaPattern[j].length]) {
                    supozaScore[j]++;
                }
            }
        }

        List<Integer> list = new ArrayList<Integer>();
        int max = Math.max(supozaScore[0], Math.max(supozaScore[1], supozaScore[2]));

        for(int i = 0; i < 3; i++) {
            if(supozaScore[i] == max) {
                list.add(i + 1);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}