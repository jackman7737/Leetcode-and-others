class Solution {
    public int getSize(int n)
    {
        int count = 0;
        while(n>0)
        {
            count++;
            n = n/10;
        }
        return count;
    }
    public int[] numToAr(int n)
    {
        int sz = getSize(n);
        int[] ar = new int[sz];
        int i =  sz-1;
        while(i>=0)
        {
            ar[i--] = n%10;
            n = n/10;
        }
        return ar;
    }
    public long arToNumber(int[] arr)
    {
        long num = 0;
        int idx = 0;
        while(idx<arr.length)
        {
            num = num*10 + arr[idx];
            idx++;
        }
        return num;
    }
    public int nextGreaterElement(int n) {
        int[] ar = numToAr(n);
        
        // checking next greater 
        
        int pc = ar.length-2;
        while(pc>=0 && ar[pc] >= ar[pc+1])
            pc--;
        
        if(pc == -1)
            return -1;
        
        // finding next greater element
        int j = ar.length-1;
        while(j>=0 && ar[j] <= ar[pc])
            j--;
        
        if(j == -1)
            return -1;
        
        // swapping
        int temp = ar[j];
        ar[j] = ar[pc];
        ar[pc] = temp;

        // reversing
        int i=pc+1, k = ar.length-1;
        while(i<=k)
        {
            int tp = ar[i];
            ar[i] = ar[k];
            ar[k] = tp;
            i++;
            k--;
        }
        for(int val : ar)
            System.out.print(val+" ");
     
        long finalans = arToNumber(ar);
        if(finalans > (int)2e31)
            return -1;
        else
               return (int)finalans; 
    }
}