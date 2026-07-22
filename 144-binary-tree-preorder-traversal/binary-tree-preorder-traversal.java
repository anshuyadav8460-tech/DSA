class Solution {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return ans;
    }

    public void preorder(TreeNode root) {
        if (root == null)
            return;

        ans.add(root.val);      // Root
        preorder(root.left);    // Left
        preorder(root.right);   // Right
    }
}