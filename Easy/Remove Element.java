class Solution {
    public int removeElement(int[] nums, int val) {
        // k = position to place next element which is NOT val
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            // If current element is not val, keep it
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
            // If it is val, skip it
        }

        return k;
    }
}S