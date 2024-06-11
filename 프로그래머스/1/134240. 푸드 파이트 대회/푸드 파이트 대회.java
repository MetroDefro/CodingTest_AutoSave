class Solution {
    public String solution(int[] food) {
        String answer = "";
        for(int i = 1; i < food.length; i++) {
            int count = food[i] / 2;
            for(int j = 0; j < count; j++) {
                answer += "" + i;
            }
        }
        StringBuffer sb = new StringBuffer(answer);
        String answerReverse = sb.reverse().toString();
        answer = answer + 0 + answerReverse;
        return answer;
    }
}