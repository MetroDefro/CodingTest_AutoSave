class Solution {
    public int solution(int n) {
        int answer = 0;

        int[] dp = new int[n + 1]; // dp 계산 수행할 배열 생성
        dp[0] = 0; // 피보나치 0일 때는 0
        dp[1] = 1; // 피보나치 1일 때는 1
        for(int i = 2; i <= n; i++) // 입력값일 2부터 n까지
        {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567; // F(n) = F(n-1) + F(n-2) 그리고 모드연산
        }
        answer = dp[n]; // 답은 n일 때
        return answer;
    }
}