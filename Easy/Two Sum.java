class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Store value -> index
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // If complement already seen, we found the pair
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            // Otherwise store current number
            map.put(nums[i], i);
        }
        
        // As per problem, one solution always exists
        return new int[]{-1, -1};
    }
}
