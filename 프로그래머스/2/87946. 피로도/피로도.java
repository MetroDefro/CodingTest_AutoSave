class Solution {
    private int count = 0;

    public int solution(int k, int[][] dungeons) {
        DFS(k, dungeons, new boolean[dungeons.length], 0);
        return count;
    }

    private void DFS(int k, int[][] dungeons, boolean[] visited, int depth) {
        if(count < depth)
            count = depth;

        if(depth == dungeons.length) {
            return;
        }

        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i]) {
                if(dungeons[i][0] <= k && dungeons[i][1] <= k) {
                    visited[i] = true;
                    DFS(k - dungeons[i][1], dungeons, visited, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
}