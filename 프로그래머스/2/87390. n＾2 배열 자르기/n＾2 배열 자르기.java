class Solution {
    public int[] solution(int n, long left, long right) {
        int length = (int) (right - left + 1);
        int[] answer = new int[length];
        int j = 0;
        for(long i = left; i <= right; i++, j++) {
            long w = i % n;
            long h = i / n;
            answer[j] = (int)(Math.max(w, h) + 1);
        }
        return answer;
    }
}