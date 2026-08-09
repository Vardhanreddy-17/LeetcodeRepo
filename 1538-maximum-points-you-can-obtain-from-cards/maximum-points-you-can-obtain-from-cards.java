class Solution {
    public int maxScore(int[] nums, int k) {
        int max = 0;
        int leftMax = 0;
        int rightMax = 0;
        int n = nums.length;
        if(n==k){
            for(int i=0;i<n;i++){
                max+=nums[i];
            }
            return max;
        }
        for(int i=0;i<k;i++){
            max+=nums[i];
        }
        int l = n-1;
        int r = k-1;
        int total = max;
        int i = 1;
        while(k-->0){
            max-=nums[r];
            r--;
            l = n-i;
            i++;
            max+=nums[l];
            total = Math.max(total,max);
        }
        return total;
    }
}