import java.util.HashSet;

class Solution {
  private HashSet<Integer> set;
  boolean[] isNotPrime = new boolean[10000000];
  public int solution(String numbers) {
    set = new HashSet<>();
    isNotPrime[0] = true;
    isNotPrime[1] = true;
    for(int i = 2; i < 10000000; i++) {
      if(isNotPrime[i]) continue;
      for(int j = i * 2; j < 10000000; j += i) {
        isNotPrime[j] = true;
      }
    }
    dfs(numbers, new boolean[numbers.length()], 0, 0);

    int answer = 0;
    for(Integer i : set) {
      if(!isNotPrime[i]) {
        answer ++;
      }
    }
    return answer;
  }

  private void dfs(String numbers, boolean[] visited, int num, int depth) {
    if(depth == numbers.length()) {
      return;
    }
    for(int j = 0; j < numbers.length(); j++) {
      if(!visited[j]) {
        visited[j] = true;
        int newNum = Integer.parseInt(Integer.toString(num) + numbers.charAt(j));
        set.add(newNum);
        dfs(numbers, visited, newNum, depth + 1);
        visited[j] = false;
      }
    }
  }
}