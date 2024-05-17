import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        String[] arr = s.split("[,{}]");
        Map<Integer, Integer> map = new HashMap<>();
        for (String string : arr) {
            if (!string.isEmpty()) {
                map.put(Integer.parseInt(string), map.getOrDefault(Integer.parseInt(string), 0) + 1);
            }
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((Integer o1, Integer o2) ->  map.get(o2).compareTo(map.get(o1)));
        answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}