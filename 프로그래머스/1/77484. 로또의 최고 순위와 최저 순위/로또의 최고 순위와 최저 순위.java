class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int min = 0;
        int max = 0;
        for(int i=0; i<lottos.length; i++) {

            if(lottos[i] == 0) {
                max++;
            }
            for(int j=0; j<win_nums.length; j++) {
                if(lottos[i] == win_nums[j]) {
                    min++;
                    max++;
                    break;
                }
            }

        }

        max = max == 0 ? 6 : 7 - max;
        min = min == 0 ? 6 : 7 - min;

        return new int[]{max, min};
    }
}