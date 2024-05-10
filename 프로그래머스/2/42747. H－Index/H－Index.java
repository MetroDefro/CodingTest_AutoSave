import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
            if(citations[i] < citations.length - i) {
                answer = citations.length - i - 1;
                break;
            }

            if(i == 0) {
                answer = citations.length;
            }
        }
        return answer;
    }
}