import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            // If already seen, duplicate found
            if (!seen.add(num)) {
                return true;
            }
        }

        return false;
    }
}