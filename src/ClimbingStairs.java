package src;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(6));
    }
    public static int climbStairs(int n) {
        int one = 1, two = 1;
        for (int i = 0; i < n - 1; i++) {
            int temp = one;
            one = one + two;
            two = temp;
        }
        return one;
    }

}
