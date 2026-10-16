class Solution {
    public TreeNode deleteNode(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.val > target) {
            root.left = deleteNode(root.left, target);
        } 
        else if (root.val < target) {
            root.right = deleteNode(root.right, target);
        } 
        else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode successor = root.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }
}
