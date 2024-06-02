class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long parseP = Long.parseLong(p);
        int length = p.length();
        for(int i = 0; i < t.length() - length + 1; i++) {
            long n = Long.parseLong(t.substring(i, i + length));
            if(n <= parseP)
                answer++;
        }
        return answer;
    }
}