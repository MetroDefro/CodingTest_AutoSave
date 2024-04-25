import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[][] giveds = new int[friends.length][friends.length]; // 주->받 준 선물 수 기록
        HashMap<String, Integer> nameIndexMap = new HashMap<>(); // friends 이름 인덱싱용
        int[] factor = new int[friends.length]; // 선물 지수 저장
        for(int i = 0; i < friends.length; i++) {
            nameIndexMap.put(friends[i], i); // 이름을 편하게 조회하기 위해 HashMap에 저장
        }

        for(int i = 0; i < gifts.length; i++) {
            String[] names = gifts[i].split(" "); // 공백을 두고 저장되어 있기 때문에 split으로 주->받 쪼갬
            giveds[nameIndexMap.get(names[0])][nameIndexMap.get(names[1])]++; // 주->받 준 선물 추가
            factor[nameIndexMap.get(names[0])]++; // 선물 준 사람 선물 지수 ++
            factor[nameIndexMap.get(names[1])]--; // 선물 받은 사람 선물 지수 --
        }

        int[] nextReceive = new int[friends.length]; // 다음 달에 받을 선물 수

        for(int i = 0; i < friends.length; i++) {
            for(int j = i + 1; j < friends.length; j++) { // 이미 계산한 관계는 제외하도록 i+1부터 시작
                if(giveds[i][j] > giveds[j][i]) // 더 많이 준 쪽의 다음 달 선물을 추가
                    nextReceive[i]++;
                else if(giveds[i][j] < giveds[j][i])
                    nextReceive[j]++;
                else { // 이번 달 주고 받은 선물 수 같을 경우, 주고 받지 않았을 경우도 둘 다 0이라 여기로 빠짐
                    if(factor[i] > factor[j]) // 선물 지수가 높은 쪽의 다음 달 선물을 추가
                        nextReceive[i]++;
                    else if(factor[i] < factor[j])
                        nextReceive[j]++;
                } // 선물 지수가 동일한 경우는 아무런 계산을 하지 않음
            }
        }

        int max = 0;
        for(int i = 0; i < nextReceive.length; i++) { // 선물을 제일 많이 받은 사람의 선물 수
            if(nextReceive[i] > max)
                max = nextReceive[i];
        }

        answer = max;
        return answer;
    }
}