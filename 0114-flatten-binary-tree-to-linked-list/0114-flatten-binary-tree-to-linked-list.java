class Solution {
    public void flatten(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        insert(root, q);
        q.poll(); 
        while (!q.isEmpty()) {
            root.right = q.poll(); 
            root.left = null;      
            root = root.right;
        }
    }
    void insert(TreeNode node, Queue<TreeNode> queue) {
        if (node == null) return;
        queue.add(node);
        insert(node.left, queue);
        insert(node.right, queue);
    }
}