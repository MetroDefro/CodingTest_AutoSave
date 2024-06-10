class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] chars = new int[26];
        for(int i = 0; i < chars.length; i++) {
            chars[i] = -1;
        }
        
        for(int i = 0; i < s.length(); i++) {
            if(chars[s.charAt(i) - 'a'] == -1)
                answer[i] = -1;
            else
                answer[i] = i - chars[s.charAt(i) - 'a'];
            
            chars[s.charAt(i) - 'a'] = i;
        }
        return answer;
    }
}