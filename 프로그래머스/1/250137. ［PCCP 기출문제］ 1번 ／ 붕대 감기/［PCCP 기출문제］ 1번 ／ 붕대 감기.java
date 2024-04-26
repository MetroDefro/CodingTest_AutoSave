import java.util.HashMap;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
int answer = 0;

        int lastTime = attacks[attacks.length - 1][0]; // 몬스터의 마지막 공격 시간
        HashMap<Integer, Integer> attacksMap = new HashMap<>(); // attacks 배열을 hashMap으로 만들어 서치 시간을 줄일 것
        for (int i = 0; i < attacks.length; i++) {
            attacksMap.put(attacks[i][0], attacks[i][1]); // 정보를 옮겨 담는다.
        }
        int continuity = 0; // 몇 초 연속 회복인지 기록
        int maxHealth = health; // 최대 체력
        int currentHealth = health; // 현재 체력

        for(int i = 1; i <= lastTime; i++) { // 1초부터 몬스터의 마지막 공격 까지
            if(attacksMap.containsKey(i)) { // 해시 맵에서 이번 초에 해당하는 key가 있는지 찾는다.
                currentHealth -= attacksMap.get(i); // 이번 초의 데미지만큼 현재 체력에서 마이너스
                continuity = 0; // 연속 성공 0으로 초기화
                if(currentHealth <= 0) { // 죽었나요?
                    return -1; // -1 리턴
                }
            } else { // 이번 초에 공격이 오지 않을 경우
                continuity++; // 연속 성공 ++
                currentHealth += bandage[1]; // 초당 회복량 +
                if(continuity >= bandage[0]) { // 만약 연속 성공이 시전 시간에 도달하였을 경우
                    currentHealth += bandage[2]; // 현재 체력에 추가 회복량 +
                    continuity = 0; // 연속 성공 0으로 초기화
                }
                if(currentHealth > maxHealth) // 만약 현재 체력이 최대 체력보다 높아졌다면?
                    currentHealth = maxHealth; // 최대 체력으로 맞춰준다.
            }
        }

        answer = currentHealth; // 여기까지 왔다면 죽지 않은 것이기 때문에 답은 남은 체력
        return answer;
    }
}