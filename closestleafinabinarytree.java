//Java Solution

class Solution {
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode match = dfs(root, k, map);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(match);
        
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            
            if (curr.left == null && curr.right == null) {
                return curr.val;
            }
            
            if (curr.left != null) {
                queue.add(curr.left);
            }
            
            if (curr.right != null) {
                queue.add(curr.right);
            }
            
            if (map.containsKey(curr)) {
                queue.add(map.get(curr));
                map.remove(curr);
            }
        }
        
        return -1;
    }
    
    public TreeNode dfs(TreeNode node, int k, Map<TreeNode, TreeNode> map) {
        if (node == null) {
            return null;
        }
        
        if (node.val == k) {
            return node;
        }
        
        if (node.left != null) {
            map.put(node.left, node);
            TreeNode left = dfs(node.left, k, map);
            
            if (left != null) {
                return left;
            }
        }
        
        if (node.right != null) {
            map.put(node.right, node);
            TreeNode right = dfs(node.right, k, map);
            
            if (right != null) {
                return right;
            }
        }
        
        return null;
    }
}