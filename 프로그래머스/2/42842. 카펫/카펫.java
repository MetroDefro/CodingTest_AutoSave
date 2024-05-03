import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};

        Map<Integer, Integer> map = new HashMap<>(); // 곱해서 yellow가 되는 값들 저장(yellow 세로가로)
        for(int i = 1; i <= yellow / 2 + 1; i++) { // yellow의 절반까지 (1의 경우를 위해 + 1)
            if(yellow % i == 0) { // i가 yellow의 소수일 경우
                map.put(i, yellow / i); // i의 짝찌와 함께 map에 넣는다.
            }
        }

        for(int i : map.keySet()) { // map 순회
            // 가능한 모든 가로세로를 가진 yellow를 둘러싸고 있는 블럭 개수
            if((map.get(i) + i + 4) * 2 - 4 == brown) {
                answer[0] = map.get(i) + 2; // 가로값
                answer[1] = i + 2; // 세로값
                break;
            }
        }

        return answer;
    }
}