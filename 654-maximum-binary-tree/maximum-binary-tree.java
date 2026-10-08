class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }
    public TreeNode build(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int maxIndex = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = build(nums, lo, maxIndex - 1);
        root.right = build(nums, maxIndex + 1, hi);
        return root;
    }
}