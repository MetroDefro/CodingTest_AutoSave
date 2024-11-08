import java.util.HashMap;

class Solution {
  public int[] solution(int[][] edges) {
    int[] answer = new int[4];
    HashMap<Integer, Integer> nodeIn = new HashMap<>();
    HashMap<Integer, Integer> nodeOut = new HashMap<>();

    for (int[] edge : edges) {
      nodeOut.put(edge[0], nodeOut.getOrDefault(edge[0], 0) + 1);
      nodeIn.put(edge[1], nodeIn.getOrDefault(edge[1], 0) + 1);
    }

    int nodeCount = 0;
    for(Integer key : nodeOut.keySet()){
      if(nodeOut.get(key) >= 2){
        if(!nodeIn.containsKey(key)){
          answer[0] = key;
          nodeCount = nodeOut.get(key);
        } else {
          answer[3]++;
        }
      }
    }

    for(Integer key : nodeIn.keySet()){
      if(!nodeOut.containsKey(key)){
        answer[2] ++;
      }
    }

    answer[1] = nodeCount - (answer[2] + answer[3]);

    return answer;
  }
}