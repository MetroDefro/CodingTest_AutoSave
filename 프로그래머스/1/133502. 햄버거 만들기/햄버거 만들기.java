import java.util.Stack;

class Solution {
  public int solution(int[] ingredient) {
    Stack<Integer> stack = new Stack<Integer>();
    int count = 0;
    for (int j : ingredient) {
      stack.push(j);
      if(stack.size() >= 4) {
        int int4 = stack.pop();
        int int3 = stack.pop();
        int int2 = stack.pop();
        int int1 = stack.pop();
        if(int4 == 1 && int3 == 3 && int2 == 2 && int1 == 1) {
          count++;
        } else {
          stack.push(int1);
          stack.push(int2);
          stack.push(int3);
          stack.push(int4);
        }
      }
    }
    return count;
  }
}