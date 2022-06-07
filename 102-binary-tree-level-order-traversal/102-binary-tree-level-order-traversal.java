/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, root, 0);
        return result;
    }
    
    public void helper(List<List<Integer>> result, TreeNode root, int depth) {
        if (root == null)
            return;
        
        if (result.size() - 1 < depth) {
            result.add(new ArrayList<>());
        }
        
        result.get(depth).add(root.val);
        
        helper(result, root.left, depth + 1);
        helper(result, root.right, depth + 1);
    }
}