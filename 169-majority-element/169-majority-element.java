class Solution {
public int majorityElement(int[] nums) {
    int n=nums.length;
    int majoritySize = n / 2;
    for(int num : nums) {
        int count = 0;
        for(int elem : nums) {
            if(num == elem) {
               count++;
               }
              }
            if(count > majoritySize) {
               return num;
               }
              }
              return -1;
              }
             }