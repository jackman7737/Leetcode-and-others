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
    static int cameras;
    public int minCameraCover(TreeNode root) {
        cameras=0;
        int ans=helper(root);
        if(ans==-1) cameras++;
        return cameras;
    }
    static int helper(TreeNode root){
       if(root==null) return 0; 
       if(root.left==null && root.right==null) return -1; 
       int left=helper(root.left);
       int right=helper(root.right);
        if(left==-1 || right==-1) {
            cameras++;
            return 1;
        }
        else if(left==0 && right==0){
         return -1;
        }
        else if(left==1 || right==1){
            return 0;
        }
        
        return 0;
    }
}