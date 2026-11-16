class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0; // position to place next non-zero

        // 1. Move all non-zeroes to front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }

        // 2. Fill remaining positions with 0
        while (insertPos < nums.length) {
            nums[insertPos] = 0;
            insertPos++;
        }
    }
}