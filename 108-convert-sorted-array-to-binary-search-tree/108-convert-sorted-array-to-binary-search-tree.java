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
    public TreeNode sortedArrayToBST(int[] nums) {
        
        if(nums.length==0){
            return null;
        }
        
        TreeNode first= sort(nums,0,nums.length-1);
        return first;
    }
    public TreeNode sort(int[] nums, int lo, int hi){
        if(lo>hi){
            return null;
        }
        int mid= (lo+hi)/2;
        TreeNode node= new TreeNode(nums[mid]);
        
        node.left=sort(nums,lo,mid-1);
        node.right=sort(nums,mid+1,hi);
        
        return node;
    }
}
