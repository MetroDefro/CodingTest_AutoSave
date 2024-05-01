class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++) { // 더하기 시작 숫자가 1부터 n이 될 때까지
            int sum = 0; // 합계를 저장할 int
            for(int j = i; j <= n; j++) { // 더하기 시작 숫자부터 연속합 시작
                sum += j; // 합계에 이번 숫자 더하기
                if(sum == n) { // 합이 n이면
                    answer++; // 더해서 n이 나왔으므로 카운트 up
                    break; // 안쪽 for문 빠져나온다
                } else if(sum > n) { // 합이 n보다 크면
                    break; // 안쪽 for문 빠져나온다
                }
            }
        }
        return answer;
    }
}