class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strs = s.split(" "); // 공백을 기준으로 한 글자씩 쪼갠다
        int max = Integer.parseInt(strs[0]); // max, min 저장소 선언 후 첫 글자를 int로 파싱하여 담아둔다.
        int min = Integer.parseInt(strs[0]);
        for (int i = 1; i < strs.length; i++) { // 두 번째 글자부터 마지막까지
            int current = Integer.parseInt(strs[i]); // 현재 글자를 int로 파싱
            if(max < current) // 현재 숫자가 max값 보다 클 경우
                max = current; // 새로운 max
            if(min > current) // 현재 숫자가 min값 보다 작을 경우
                min = current; // 새로운 min
        }
        answer = min + " " + max; // 출력 형식에 맞춰 String으로 만든다
        return answer;
    }
}