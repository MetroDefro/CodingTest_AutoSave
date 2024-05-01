class Solution {
    public int[] solution(String s) {
        int count = 0; // 로직 반복 횟수 카운트
        int count0 = 0; // 전체 0이 나온 횟수 카운트
        int count1 = 0; // 한 로직 안에서 1이 나온 횟수 카운트

        while (s.length() > 1) {
            count++; // 반복 횟수 추가
            count1 = 0; // 1이 나온 횟수 0으로 초기화

            for(int i = 0; i < s.length(); i++) { // s 순회
                if(s.charAt(i) == '0') { // 이번 숫자가 0이면
                    count0++; // 0 카운트
                } else {
                    count1++; // 1 카운트
                }
            }
            // 1이 나온 수를 2진수로 바꾸고 또 문자열로 바꿈
            s = Integer.toBinaryString(count1).toString();
        }

        int[] answer = {count, count0}; // 답에 반복 횟수와 0이 나온 횟수를 담는다.
        return answer;
    }
}