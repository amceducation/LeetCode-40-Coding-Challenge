class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        // XOR all numbers
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}