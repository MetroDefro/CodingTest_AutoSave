class Solution {
    public int solution(int n) {
        int nCount1 = count(n); // n의 1의 갯수
        int count1 = 0; // 다음 수들의 1의 갯수를 저장할 곳
        int addInt = 0; // n에 더해질 수
        while (count1 != nCount1) { // 1의 갯수가 서로 다른 동안
            addInt++; // n에 더해질 수 증가
            count1 = count(n + addInt); // 이번 수의 1의 갯수
        }

        int answer = n + addInt; // 1의 갯수가 최초로 같은 수
        return answer;
    }

    public int count(int n) { // 어떤 int의 2진수 변환 시 1의 갯수를 세는 메서드
        String str = Integer.toBinaryString(n); // 숫자를 2진수 String으로 변환
        int count = 0; // 1의 갯수를 세어 저장할 곳
        for(int i = 0; i < str.length(); i++) { // String을 순회
            if (str.charAt(i) == '1') // 이번 자릿수가 1인가?
                count++; // count up
        }
        return count; // 1의 갯수를 세어 반환
    }
}