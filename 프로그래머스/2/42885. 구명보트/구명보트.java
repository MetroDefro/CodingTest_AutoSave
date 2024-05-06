import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int safePeople = 0;
        int big = people.length - 1;
        int small = 0;
        Arrays.sort(people);
        while (safePeople < people.length) {
            answer++;
            if(people[big] + people[small] <= limit) {
                small++;
                safePeople += 2;
            } else {
                safePeople += 1;
            }
            big--;
        }

        return answer;
    }
}