import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] babbling) {
        Map<Character, String> words = new HashMap<>();
        words.put('a', "aya");
        words.put('y', "ye");
        words.put('w', "woo");
        words.put('m', "ma");

        int answer = 0;

        for (String string : babbling) {
            String prev = "";
            for (int j = 0; j < string.length();) {
                if(!words.containsKey(string.charAt(j))) {
                    break;
                }
                String word = words.get(string.charAt(j));

                if(string.startsWith(word, j)){

                    if(!prev.equals(word)) {
                        if(j + word.length() == string.length()) {
                            answer ++;
                        }

                        prev = word;
                        j += word.length();
                        continue;
                    }
                }
                break;
            }
        }
        return answer;
    }
}