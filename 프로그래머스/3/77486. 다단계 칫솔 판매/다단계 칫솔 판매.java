import java.util.HashMap;

class Solution {
  public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
    HashMap<String, Integer> map = new HashMap<>();
    for(int i = 0; i < enroll.length; i++) {
      map.put(enroll[i], i);
    }

    int[] answer = new int[enroll.length];
    for(int i = 0; i < seller.length; i++) {
      int index = map.get(seller[i]);
      int profit = amount[i] * 100;
      while(true) {
        int tip = (int) (profit * 0.1);
        answer[index] += profit - tip;
        profit = tip;
        if(profit < 1) {
          break;
        }
        if(referral[index].equals("-")) {
          break;
        }
        index = map.get(referral[index]);
      }
    }

    return answer;
  }
}