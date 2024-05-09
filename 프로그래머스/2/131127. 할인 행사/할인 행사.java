import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        Map<String, Integer> discountMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        for (int i = 0; i < discount.length; i++) {
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
            if(i < 9) {
                continue;
            }

            int count = 0;
            for(String str : wantMap.keySet()) {
                if(discountMap.containsKey(str) && Objects.equals(discountMap.get(str), wantMap.get(str))) {
                    count += discountMap.get(str);
                }
            }
            if(count == 10) {
                answer++;
            }
            discountMap.put(discount[i - 9], discountMap.get(discount[i - 9]) - 1);
        }
        return answer;
    }
}