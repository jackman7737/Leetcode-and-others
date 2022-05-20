class Solution {
    public void rotate(int[] nums, int k) 
    {
         int size=nums.length; 
         k =k % size;
         reverse(nums,0,size-1);    //[1,2,3,4,5,6,7]----> [7,6,5,4,3,2,1]
         reverse(nums,0,k-1);       //[7,6,5,4,3,2,1]----> [5,6,7,4,3,2,1]
         reverse(nums,k,size-1);    //[5,6,7,4,3,2,1]----->[5,6,7,1,2,3,4]
       
        
    }
    
    public void reverse(int[] res,int start,int end)
    {
        
        
        while(start < end)
        {
            int temp =res[end];
            res[end]=res[start];
            res[start]=temp;
            
            start++;
            end--;
        }
    }
}