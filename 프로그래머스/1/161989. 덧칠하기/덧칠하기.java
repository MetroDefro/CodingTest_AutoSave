class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] visited = new boolean[n + 1];
        for (int k : section) {
            if (!visited[k]) {
                answer++;
                for (int j = k; j < k + m; j++) {
                    if(j > n) {
                        break;
                    }
                    visited[j] = true;
                }
            }
        }
        return answer;
    }
}