class Solution {
  public int solution(int n, int[] tops) {
    int[] dp = new int[n * 2 + 1];
    dp[0] = 1;
    if(tops[0] == 0) {
      dp[1] = 2;
      dp[2] = 3;
    } else {
      dp[1] = 3;
      dp[2] = 4;
    }

    for(int i = 1, j = 3; i < n; i++, j+=2) {
      if(tops[i] == 0) {
        dp[j] = (dp[j - 1] + dp[j - 2]) % 10007;
      } else {
        dp[j] = (dp[j - 1] + dp[j - 1] + dp[j - 2]) % 10007;
      }
      dp[j + 1] = (dp[j] + dp[j - 1]) % 10007;
    }

    return dp[n * 2];
  }
}