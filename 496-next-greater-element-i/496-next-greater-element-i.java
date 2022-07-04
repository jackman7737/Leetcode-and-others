class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int M = nums1.length, N = nums2.length;
        
        int[] greater = new int[10001];
        for(int i = N - 1; i >= 0; i--) {
            while(stack.size() > 0 && stack.peek() < nums2[i])
                stack.pop();
            greater[nums2[i]] = stack.size() == 0 ? -1 : stack.peek();
            stack.push(nums2[i]);
        }
        
        int[] result = new int[M];
        for(int i = 0; i < M; i++)
            result[i] = greater[nums1[i]];
        
        return result;
    }
}