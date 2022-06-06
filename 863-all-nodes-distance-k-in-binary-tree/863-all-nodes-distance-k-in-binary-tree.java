/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 
class Solution {
    private List<TreeNode> printKlevelDown(TreeNode target, TreeNode blocker, int k) {
        if(target==null || k<0||target==blocker){
            return;
        }
        if(k==0){
            return target.val;
        }
        printKlevelDown(target.left,blocker,k-1);
        printKlevelDown(target.right,blocker,k-1);
    }
    private List<TreeNode> targettoRootPath(TreeNode target,int data){
        if(target==null){
            return new ArrayList<>();
        }
        if(target.val==data){
            ArrayList<TreeNode> list=new ArrayList<>();
            list.add(target);
            return list;
        }
        ArrayList<TreeNode> llist=targettoRootPath(target.left,data);
        if(llist.size()>0){
            llist.add(target);
            return llist;
        }
        ArrayList<TreeNode> rlist=targettoRootPath(target.right,data);
        if(rlist.size()>0){
            rlist.add(target);
            return rlist;
        }
        return new ArrayList<>();
    }
    public List<TreeNode> distanceK(TreeNode target, TreeNode data, int k) {
        ArrayList<TreeNode> n2rpath=targettoRootPath(target,data);
        for(int i=0;i<n2rpath.size();i++){
            printKlevelDown(n2rpath.get(i),k-i,i>0?n2rpath.get(i-1):null);
        }
        
}}
*/
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> dist = new ArrayList<Integer>(); 
				// Note : Since target is always in the tree, we can do this.
        if( K == 0){
            dist.add(target.val); 
            return dist; 
        }
        traverse(dist, root, target, K, 0); 
        return dist; 
    }
    public int traverse(List<Integer> dist, TreeNode root, TreeNode target, int k, int val){
        if(root == null) 
            return 0; 
						// val == k implies that we are at the k-th distant child from the target
        if(val == k){
            dist.add(root.val); 
            return 0; 
        }
        int left = 0, right = 0; 
				
				// either we find the target or we have already found the target propagate val+1
        if(root.val == target.val || val > 0 ){
            left = traverse(dist, root.left, target, k, val+1); 
            right = traverse(dist, root.right, target, k, val+1); 
        }
				
				// else propagate the 0
        else {
            left = traverse(dist, root.left, target, k, val); 
            right = traverse(dist, root.right, target, k, val); 
        }
				
				// If a node receives a k in return it is k-th distant parent from the the target.
        if(left == k || right == k){
            dist.add(root.val); 
            return 0; 
        }
				
				// Target node must return 1 other must return 0 if their subtree doesnt have target.
        if(root.val == target.val){
            return 1; 
        }
				
				// If left or right is greater than 0 that means one of the subtree has the target. Propagate the new value in the other subtree. 
        if(left > 0){
            traverse(dist, root.right, target, k, left + 1); 
        }
        if(right > 0){
            traverse(dist, root.left, target, k, right+1); 
        }
				// If the subtree has target, return the distance from target +1 
        if(left > 0 || right > 0)
            return left > 0 ? left + 1 : right + 1; 
						
				// else return 0. 
        return 0; 
    }
}