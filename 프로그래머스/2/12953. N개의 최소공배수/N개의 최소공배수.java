class Solution {
    public int solution(int[] arr) {
        int answer = 0;

        int max = arr[0]; // 배열 중 최대값을 구하는 코드
        for(int i = 1; i < arr.length; i++) {
            if(max < arr[i])
                max = arr[i];
        }

        int i = 1; // 최대값에 곱할 수 (배수)
        while (true) {
            int count = 0; // 이번 수가 나누어 떨어지는 횟수.
            for (int k : arr) { // 배열 순회하며
                if (max * i % k != 0) { // 나누어 떨어지는지 검사
                    break; // 나누어 떨어지지 않았으니 나가기.
                }
                count++; // 나누어 떨어졌으므로 횟수 증가
            }
            if(count == arr.length) { // 모든 수가 나누어 떨어진 것 확인
                answer = max * i; // 이번 배수 값이 답
                break; // 루프 나가기
            }

            i++; // 다음 배수 시작
        }

        return answer;
    }
}