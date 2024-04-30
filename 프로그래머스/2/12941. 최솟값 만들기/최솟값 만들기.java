import java.util.Arrays;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A); // A 배열 정렬
        Arrays.sort(B); // B 배열 정렬

        for(int i = 0; i < A.length; i++) { // 전체 순회 하며
            answer += A[i] * B[A.length - 1 - i]; // A 배열은 제일 첫 원소부터, B 배열은 제일 뒤 원소부터 곱한다.
            // 곱한 값은 answer에 누적 합
        }
        
        return answer;
    }
}