class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        boolean[] isNotPrime = new boolean[2998];
        for(int i = 2; i <= 2997; i++) {
            if(isNotPrime[i])
                continue;
            for(int j = i * 2; j <= 2997; j += i) {
                isNotPrime[j] = true;
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    if(!isNotPrime[nums[i] + nums[j] + nums[k]])
                        answer++;
                }
            }
        }

        return answer;
    }
}