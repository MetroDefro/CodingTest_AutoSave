import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++) { // 문자열 길이만큼 순회
            Stack<Character> stack = new Stack<>(); // 스택 선언
            int j = i; // 회전 시키기 위해 시작 값을 이번 인덱스로
            do {
                if(s.charAt(j) == '[' || s.charAt(j) == '{' || s.charAt(j) == '(') {
                    stack.push(s.charAt(j)); // [, {, (인 경우 push
                }
                else {
                    if(!stack.isEmpty() &&
                            ((s.charAt(j) == ']' && stack.peek() == '[') ||
                             (s.charAt(j) == '}' && stack.peek() == '{') ||
                             (s.charAt(j) == ')' && stack.peek() == '('))) {
                        stack.pop(); // stack이 비어있지 않고, 맨 위에 있는 괄호가 짝인 경우 꺼냄
                    } else {
                        stack.push(s.charAt(i)); // 아니면 push
                    }
                }
                j ++; // 다음 문자로
                if(j >= s.length()) { // 만약 마지막 문자 이상으로 가면
                    j = 0; // 다시 0번부터 시작
                }
            } while (j != i); // 한 바퀴를 돌아오면 종료
            if(stack.isEmpty()) // 스택 비어있으면
                answer++; // 올바른 괄호 문자열
        }
        return answer;
    }
}