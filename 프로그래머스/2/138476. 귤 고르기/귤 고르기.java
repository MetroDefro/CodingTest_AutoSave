import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // 해쉬맵 이용한다
        for(int i = 0; i < tangerine.length; i++){
            // 각 크기의 귤 수를 맵에 담는다.
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        // Map value로 정렬하는 부분
        Map<Integer, Integer> result = map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (a, b) -> { throw new AssertionError(); },
                LinkedHashMap::new
        ));

        int sum = 0;
        for(Map.Entry<Integer, Integer> entry : result.entrySet()){ // 맵 순회
            sum += entry.getValue(); // 이번 크기의 귤의 수 더하기
            answer++; // 필요한 크기 수가 늘어났으니 ++
            if(sum >= k){ // 이번 크기 귤들을 더하면 k보다 많거나 같은가?
                break;
            }
        }

        return answer;
    }
}