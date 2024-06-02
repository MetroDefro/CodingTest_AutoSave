class Solution {
    public int solution(int[] number) {
        int answer = 0;
        for(int i = 0; i < number.length; i++) {
            for(int j = i + 1; j < number.length; j++) {
                for(int r = j + 1; r < number.length; r++) {
                    if(number[i] + number[j] + number[r] == 0)
                        answer ++;
                }
            }
        }
        return answer;
    }
}