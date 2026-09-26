import java.util.*;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(0, nums, new ArrayList<>(), ans);

        return ans;
    }

    private void helper(int idx, int[] nums,
                        List<Integer> curr,
                        List<List<Integer>> ans) {

        if (idx == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // take
        curr.add(nums[idx]);
        helper(idx + 1, nums, curr, ans);

        // skip
        curr.remove(curr.size() - 1);
        helper(idx + 1, nums, curr, ans);
    }
}