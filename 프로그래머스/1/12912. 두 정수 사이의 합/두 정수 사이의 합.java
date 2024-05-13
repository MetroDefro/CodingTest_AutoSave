class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int bigger, smaller;
        if(b > a) {
            bigger = b;
            smaller = a;
        }
        else {
            bigger = a;
            smaller = b;
        }
        for(int i = smaller; i <= bigger; i++) {
            answer += i;
        }
        return answer;
    }
}