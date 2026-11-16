import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] candidates, int remain, int start, List<Integer> curr, List<List<Integer>> ans) {
        if (remain == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (remain < 0) return;

        for (int i = start; i < candidates.length; i++) {
            curr.add(candidates[i]);
            // i hi pass karo, i+1 nahi - kyuki same number dobara use ho sakta hai
            backtrack(candidates, remain - candidates[i], i, curr, ans);
            curr.remove(curr.size() - 1); // backtrack
        }
    }
}