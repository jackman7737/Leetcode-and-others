/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
       if( root == null) return root; 
       Queue<Node> queue = new LinkedList();
       queue.offer(root);
       while(!queue.isEmpty()) {
          Node prev = queue.poll(); 
          int size = queue.size(); 
          if(prev.left != null) queue.offer(prev.left); 
          if(prev.right != null) queue.offer(prev.right);  
          for(int i=0; i<size; i++) {
              Node node = queue.poll();
              prev.next = node;
              prev = node;
             if(prev.left != null) queue.offer(prev.left); 
             if(prev.right != null) queue.offer(prev.right);  
          } 
          prev.next = null; 
       } 
        return root;
    }
}