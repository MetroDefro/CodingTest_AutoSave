class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int x = 0; x < arr1.length; x++) {
            for(int y = 0; y < arr2[0].length; y++) {
                for(int i = 0; i < arr1[0].length; i++) {
                    answer[x][y] += arr1[x][i] * arr2[i][y];
                }
            }
        }
        return answer;
    }
}