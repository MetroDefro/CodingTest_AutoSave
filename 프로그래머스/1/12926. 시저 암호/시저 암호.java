class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i = 0; i < s.length(); i++) {
            int cur = (int)s.charAt(i);
            if(cur >= (int)'A' && cur <= (int)'Z') {
                if(cur + n <= (int)'Z') {
                    answer += (char)(cur + n);
                } else {
                    answer += (char)(cur + n - 26);
                }
            } else if(cur >= (int)'a' && cur <= (int)'z') {
                if(cur + n <= (int)'z') {
                    answer += (char)(cur + n);
                } else {
                    answer += (char)(cur + n - 26);
                }
            } else {
                answer += ' ';
            }
        }
        return answer;
    }
}