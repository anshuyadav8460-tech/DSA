import java.util.*;
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        helper(root, "", ans);
        return ans;
    }
    private void helper(TreeNode root, String path, List<String> ans) {
        if (root == null) {
            return;
        }
        path += root.val;
        if (root.left == null && root.right == null) {
            ans.add(path);
            return;
        }
        path += "->";
        helper(root.left, path, ans);
        helper(root.right, path, ans);
    }
}
