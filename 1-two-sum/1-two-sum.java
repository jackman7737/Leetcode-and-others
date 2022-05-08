import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
   
       int[] ans = new int[2];
        int counter = 0;
      
        int k = 0;
        
        if (nums[0] + nums[1] == target) k = 1;  ans[1] = 1;
      
        if (nums[nums.length-1] + nums[nums.length-2] == target){
            k = 1; ans[0] = nums.length-1; ans[1] =nums.length-2;  
        }
        while (k != 1) {
            for (int i = 0; i < nums.length; i++) {
               if (counter < nums.length) counter++;
                for (int j = counter; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        k = 1;
                        ans[0] = i;
                        ans[1] = j;
                        break;
                    }
                }
                if (k == 1 || counter == nums.length-1) break;
            }
        }


        return  ans;
    }
}