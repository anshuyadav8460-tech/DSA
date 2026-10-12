class Solution {
    int maxLevel = -1;
    int ans = 0;
    public int findBottomLeftValue(TreeNode root) {
        solve(root, 0);
        return ans;
    }
    private void solve(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level > maxLevel) {
            maxLevel = level;
            ans = root.val;
        }
        solve(root.left, level + 1);
        solve(root.right, level + 1);
    }
}
