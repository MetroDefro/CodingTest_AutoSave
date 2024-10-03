import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        String[] inputs = cs.nextLine().split(" ");
        int H = Integer.parseInt(inputs[0]);
        int W = Integer.parseInt(inputs[1]);
        int N = Integer.parseInt(inputs[2]);
        int M = Integer.parseInt(inputs[3]);

        int y = (int)Math.ceil(H / (1.0 + N));
        int x = (int)Math.ceil(W / (1.0 + M));

        System.out.println(y * x);
    }
}