import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        Stack<Character> stack = new Stack<Character>(); // char 담을 스택 생성

        for(int i = 0; i < s.length(); i++) { // 문자열 순회
            // 스택이 비어있지 않고 맨 위 char이 현재 char과 같다면
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)) { 
                stack.pop(); // 맨 위에 꺼내기
            } else { // 아니면
                stack.push(s.charAt(i)); // 넣기
            }
        }

        if(stack.isEmpty()) // 스택이 비어있으면 모든 문자 제거한 것
            answer = 1; // 1 반환
        else // 비어있지 않으면 짝이 안 맞는 문자가 있던 것
            answer = 0; // 0 반환

        return answer;
    }
}