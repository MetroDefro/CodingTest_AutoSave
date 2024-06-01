class Solution {
    public String solution(String s) {
        String answer = "";
        boolean isEven = true;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                isEven = true;
                answer += " ";
              continue;
            }

            if(isEven) {
                answer += s.substring(i, i + 1).toUpperCase();
            } else {
                answer += s.substring(i, i + 1).toLowerCase();
            }

            isEven = !isEven;
        }
        return answer;
    }
}