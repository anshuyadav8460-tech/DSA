class Solution {
    TreeNode start;
    HashMap<TreeNode, TreeNode> parent = new HashMap<>();
    public int amountOfTime(TreeNode root, int target) {
        start = null;
        parent.clear();
        dfs(root, null, target);
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        q.add(start);
        visited.add(start);
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean burned = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                if (node.left != null && visited.add(node.left)) {
                    q.add(node.left);
                    burned = true;
                }
                if (node.right != null && visited.add(node.right)) {
                    q.add(node.right);
                    burned = true;
                }
                TreeNode par = parent.get(node);
                if (par != null && visited.add(par)) {
                    q.add(par);
                    burned = true;
                }
            }
            if (burned) time++;
        }
        return time;
    }
    private void dfs(TreeNode root, TreeNode par, int target) {
        if (root == null) return;
        if (root.val == target) {
            start = root;
        }
        if (par != null) {
            parent.put(root, par);
        }
        dfs(root.left, root, target);
        dfs(root.right, root, target);
    }
}