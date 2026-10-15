class Quad {
    int max;
    int min;
    int sum;
    boolean isBst;
    Quad(int max, int min, int sum, boolean isBst) {
        this.max = max;
        this.min = min;
        this.sum = sum;
        this.isBst = isBst;
    }
}
class Solution {
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxSum;
    }
    Quad helper(TreeNode root) {
        if (root == null) {
            return new Quad(
                Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                0,
                true
            );
        }
        Quad left = helper(root.left);
        Quad right = helper(root.right);
        if (left.isBst && right.isBst &&
            root.val > left.max &&
            root.val < right.min) {
            int sum = left.sum + right.sum + root.val;
            maxSum = Math.max(maxSum, sum);
            int max = Math.max(root.val, right.max);
            int min = Math.min(root.val, left.min);
            return new Quad(max, min, sum, true);
        }
        return new Quad(
            Integer.MAX_VALUE,
            Integer.MIN_VALUE,
            0,
            false
        );
    }
}
