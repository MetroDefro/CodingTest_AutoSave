import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        int standardExt = parse_index(ext);
        int standardSort = parse_index(sort_by);

        int[][] extData = Arrays.stream(data).filter(x -> x[standardExt] < val_ext).toArray(int[][]::new);

        Arrays.sort(extData, Comparator.comparingInt(o -> o[standardSort]));

        answer = extData;

        return answer;
    }

    public int parse_index(String standard){
        int index = 0;
        switch (standard) { // 뽑아낼 데이터 기준
            case "code": // 제일 왼쪽 열일 경우부터 순서대로
                index = 0; // 열의 인덱스를 저장
                break;
            case "date":
                index = 1;
                break;
            case "maximum":
                index = 2;
                break;
            case "remain":
                index = 3;
                break;
        }

        return index;
    }
}