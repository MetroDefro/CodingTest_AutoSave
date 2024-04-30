class Solution {
    public String solution(String s) {
        String answer = "";
        boolean isFirst = true; // 첫 문자인지 판별에 쓰임
        for(int i = 0; i < s.length(); i++) { // 모든 글자 순회
            if(s.charAt(i) == ' ') { // 이번 글자가 공백일 경우
                answer += ' '; // 답에 공백 추가
                isFirst = true; // 다음 문자는 첫 번째 문자가 됨 (혹은 공백)
            } else if (isFirst) { // 첫번째 문자일 경우
                answer += s.substring(i, i + 1).toUpperCase(); // 대문자
                isFirst = false; // 다음 문자는 첫 번째 문자가 아님 (혹은 공백)
            } else { // 첫 번째 문자가 아닌 경우
                answer += s.substring(i, i + 1).toLowerCase(); // 소문자
            }
        }
        return answer;
    }
}