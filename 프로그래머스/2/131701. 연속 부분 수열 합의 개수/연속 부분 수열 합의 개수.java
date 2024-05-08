import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<Integer>(); // 중복을 방지하기 위한 set
        for (int i = 0; i < elements.length; i++) {
            int sum = 0; // 누적 합 구할 것
            int j = i; // 인덱스(더할 수)를 현재 숫자에서 시작
            do {
                sum += elements[j]; // 누적합 진행
                set.add(sum); // set에 이번 합 추가
                j ++; // j 증가(더하는 수 더 늘어남)
                if(j >= elements.length) { // 만약 마지막 원소 이상으로 가면
                    j = 0; // 다시 0번부터 시작
                }
            } while (j != i); // 한 바퀴를 돌아오면 종료
        }

        answer = set.size(); // set의 사이즈를 반환
        return answer;
    }
}