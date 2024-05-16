import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        List<Integer> list = new ArrayList<Integer>();
        for (int j : arr) {
            if (j % divisor == 0) {
                list.add(j);
            }
        }
        if (!list.isEmpty()) {
            answer = list.stream().mapToInt(i -> i).toArray();
            Arrays.sort(answer);
        } else {
            answer = new int[1];
            answer[0] = -1;
        }
        return answer;
    }
}