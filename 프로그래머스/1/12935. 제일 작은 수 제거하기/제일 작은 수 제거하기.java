class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length - 1];
        int min = arr[0];
        int minIndex = 0;
        
        if(arr.length == 1)
            return new int[] {-1};
        
        for(int i = 0; i < arr.length; i++) {
            if(min > arr[i]) {
                min = arr[i];
                minIndex = i;              
            }
        }
        
        for(int i = 0, j = 0; i < arr.length; i++) {
            if(i == minIndex)
                continue;
            answer[j] = arr[i];
            j++;
        }
        return answer;
    }
}