import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Frequency map
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        // 2. Bucket: index = frequency, value = us frequency wale numbers
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            bucket[e.getValue()].add(e.getKey());
        }

        // 3. Peeche se k elements uthao
        int[] ans = new int[k];
        int idx = 0;
        for (int i = bucket.length - 1; i >= 0 && idx < k; i--) {
            for (int num : bucket[i]) {
                ans[idx++] = num;
                if (idx == k) break;
            }
        }
        return ans;
    }
}