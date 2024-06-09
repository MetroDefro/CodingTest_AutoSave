import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                set.add(numbers[j]+numbers[i]);
            }
        }

        int[] answer = set.stream().mapToInt(i->i).toArray();
        Arrays.sort(answer);
        return answer;
    }
}