class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int min = nums[0];
        int max = nums[0];
        for (int ele : nums) {
            set.add(ele);
            min = Math.min(min, ele);
            max = Math.max(max, ele);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = min + 1; i < max; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }
        return ans ;
    }
}