import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        String input = cs.nextLine();
        while (!input.equals("0 0 0")) {
            String[] inputs = input.split(" ");
            int[] nums = new int[3];
            for(int i = 0; i < 3; i ++) {
                nums[i] = Integer.parseInt(inputs[i]);
            }
            Arrays.sort(nums);

            if(nums[2] >= nums[0] + nums[1]) {
                System.out.println("Invalid");
            } else if(nums[2] == nums[1] && nums[1] == nums[0]) {
                System.out.println("Equilateral");
            } else if(nums[2] == nums[0] || nums[0] == nums[1] || nums[1] == nums[2]) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
            input = cs.nextLine();
        }

    }
}