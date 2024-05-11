import java.util.Arrays;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String str = String.valueOf(n);
        int[] temp = new int[str.length()];
        for(int i = 0; i < temp.length; i++) {
            temp[i] = (int)(n % 10);
            n /= 10;
        }
        Arrays.sort(temp);
        String newStr = "";
        for(int i = temp.length - 1; i >= 0 ; i--) {
            newStr += String.valueOf(temp[i]);
        }
        answer = Long.parseLong(newStr);
        return answer;
    }
}