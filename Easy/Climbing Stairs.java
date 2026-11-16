class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        // It's just Fibonacci!
        // ways(n) = ways(n-1) + ways(n-2)
        int first = 1;  // ways for 1 stair
        int second = 2; // ways for 2 stairs
        int curr = 0;

        for (int i = 3; i <= n; i++) {
            curr = first + second;
            first = second;
            second = curr;
        }

        return second;
    }
}