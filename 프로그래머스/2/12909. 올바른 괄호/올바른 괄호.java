import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<Character>(); // '(', ')'를 담을 Character 스택
        for(int i = 0; i < s.length(); i++) { // 문자열을 순회하며
            if(s.charAt(i) == '(') { // '('괄호가 나왔을 경우
                stack.push('('); // 무조건 집어 넣는다.
            }
            else if(s.charAt(i) == ')') { // 만약 ')'괄호가 나왔다면
                if(!stack.empty()) { // stack이 비어있지 않고
                    if(stack.peek() == '(') { // 현재 제일 위에 있는 게 '('괄호일 때
                        stack.pop(); // 꺼낸다
                    }
                } else { // stack이 비어있거나 제일 위에 있는 게 '('괄호가 아닐 경우
                        stack.push(')'); // 넣는다.
                    }
            }
        }

        if(!stack.empty()) // 작업 수행 후에도 stack이 비어있지 않다면
            answer = false; // false이다. (위에서 true로 선언되어 있는 상태)

        return answer;
    }
}