import java.util.Scanner;

class Main {

  public static void main(String[] args) {

    Scanner cs = new Scanner(System.in);

    int N = Integer.parseInt(cs.nextLine());
    int M = Integer.parseInt(cs.nextLine());
    String[] input = cs.nextLine().split(" ");
    int[] place = new int[M];
    for(int i = 0; i < M; i++) {
      place[i] = Integer.parseInt(input[i]);
    }

    System.out.println(binarySearch(place, N, M));


  }

  private static int binarySearch(int[] arr, int N, int M) {
    int low = 1;
    int high = N;
    while(low <= high) {
      int mid = (low + high) / 2;

      int prev = -1;
      for(int j = 0; j < M; j++) {
        if(prev + 1 < arr[j] - mid) {
          low = mid + 1;
          break;
        }
        prev = arr[j] + mid - 1;

        if(j == M - 1) {
          if(prev < N - 1) {
            low = mid + 1;
          } else {
            high = mid - 1;
          }
        }
      }
    }
    return low;
  }

}