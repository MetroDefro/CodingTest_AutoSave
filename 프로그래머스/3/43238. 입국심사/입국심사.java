class Solution {
  public long solution(int n, int[] times) {
    long low = 0;
    long high = 1000000000000000000L;

    while (low <= high) {
      long mid = (low + high) / 2;
      long sum = 0;
      for (int time : times) {
        sum += mid / time;
        if(sum >= n) {
          break;
        }
      }
      if(sum < n) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return low;
  }
}