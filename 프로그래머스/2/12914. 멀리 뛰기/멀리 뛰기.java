class Solution {
    public long solution(int n) {
        if(n == 1) // 1일 경우는 예외처리
        {
            return 1;
        }
        int[] dp = new int[n + 1]; // 1칸~n칸까지 가는 모든 경우의 수를 담을 배열
        dp[1] = 1; // 1칸까지 가는 경우는 1칸 뛰기 1개
        dp[2] = 2; // 2칸까지 가는 경우는 2칸 뛰기와 1+1칸 뛰기 2개
        for (int i = 3; i <= n; i++) { // i번째 칸까지 가는 경우의 수 구하기
            // i-1칸에서 1칸 뛰는 경우와 i-2칸에서 2칸 뛰는 방법이 있음
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567; // 모듈러 연산 잊지 않기
        }
        return dp[n];
    }
}