class Solution {
    public String solution(int a, int b) {
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] startDays = {5, 1, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        return days[((b - 1) + startDays[a - 1]) % 7];
    }
}