class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2]; // 배열 초기화 (0, 0)
        if(words[0].length() == 1) { // 첫 번째 단어 길이가 1일 경우 예외처리
            answer[0] = 1;
            answer[1] = 1;
            return answer;
        }
        boolean isBreak = false;
        for(int i = 1; i < words.length; i++) { // 단어 순회
            // 만약 이전 마지막 글자와 현재 첫 글자가 다르거나 이번 단어가 한 글자이면
            if(words[i].length() == 1 ||
               words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                answer = getAnswer(i, n); // 답 가져오기
                break;
            }
            for(int j = 0; j < i; j++) { // 이전에 나온 단어들 찾아봄
                if(words[i].equals(words[j])) { // 이미 있는 단어면
                    answer = getAnswer(i, n); // 답 가져오기
                    isBreak = true;
                    break;
                }
            }
            if(isBreak)
                break;
        }
        return answer;
    }
    // 답 가져오는 메서드
    private int[] getAnswer(int i, int n) {
        int[] answer = new int[2];
        int turn = i % n; // 진행 횟수에서 사람 수 나머지 연산을 해 몇 번째 번호인지 구함
        int round = i / n; // 진행 횟수에서 사람 수 나누기 연산을 해 몇 번째 차례인지 구함
        answer[0] = turn + 1;
        answer[1] = round + 1;
        return answer;
    }
}