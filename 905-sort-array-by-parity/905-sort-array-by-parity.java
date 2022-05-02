class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[]ans=new int[nums.length];
        int c=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2==0)
            {
                ans[c]=nums[i];
                c++;
            }
        }
       
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2==1)
            {
                ans[c]=nums[i];
                c++;
            }
        }
        return ans;
    }
    
}
