class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int[] counts = new int[right + 1];
        for(int i = 1; i < counts.length; i++) {
            for(int j = i; j < counts.length; j += i) {
                counts[j]++;
            }
        }
        for(int i = left; i <= right; i++) {
            if(counts[i] % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }
}