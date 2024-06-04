class Solution {
    public int solution(int[][] sizes) {
        int w = 0;
        int h = 0;
        for(int i = 0; i < sizes.length; i++) {
            int curW, curH;
            if(sizes[i][0] < sizes[i][1]) {
                curW = sizes[i][1];
                curH = sizes[i][0];
            } else {
                curW = sizes[i][0];
                curH = sizes[i][1];
            }
            
            if(w < curW) {
                w = curW;
            }
            if(h < curH) {
                h = curH;
            }
        }
        return w * h;
    }
}