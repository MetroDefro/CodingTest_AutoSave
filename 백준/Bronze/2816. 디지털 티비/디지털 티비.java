import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        int n = Integer.parseInt(cs.nextLine());
        String[] channels = new String[n];
        int KBS1Num = 0, KBS2Num = 0;
        for(int i = 0; i < n; i++){
            channels[i] = cs.nextLine();
            if(channels[i].equals("KBS1")){
                KBS1Num = i;
            }
            else if(channels[i].equals("KBS2")){
                KBS2Num = i;
            }
        }

        StringBuilder result = new StringBuilder();

        result.append("1".repeat(KBS1Num));
        result.append("4".repeat(KBS1Num));

        if(KBS1Num < KBS2Num) {
            result.append("1".repeat(KBS2Num));
            result.append("4".repeat(KBS2Num - 1));
        } else {
            result.append("1".repeat(KBS2Num + 1));
            result.append("4".repeat(KBS2Num));
        }

        System.out.println(result);
    }
}