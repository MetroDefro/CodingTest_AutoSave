import java.util.ArrayList;
import java.util.List;

class Solution {
  public int solution(String word) {
    char[] words = {'A', 'E', 'I', 'O', 'U'};
    List<String> strings = new ArrayList();
    dfs(strings, words, 0, "");

    return strings.indexOf(word) + 1;
  }

  private static void dfs(List<String> strings, char[] words, int depth, String cur) {
    if(depth >= 5) {
      return;
    }

    for (char c : words) {
      String word = cur + c;
      strings.add(word);
      dfs(strings, words, depth + 1, word);
    }
  }
}