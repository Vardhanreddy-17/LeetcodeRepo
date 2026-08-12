class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return findSub(nums,goal)-findSub(nums,goal-1);
    }
    public int findSub(int[] nums,int goal){
        if(goal==-1) return 0;
        int l = 0;
        int r = 0;
        int count = 0;
        int sum = 0;
        while(l<nums.length && r<nums.length){
            sum+=nums[r];
            while(sum>goal){
                sum-=nums[l];
                l++;
            }
            count+=(r-l+1);
            r++;
        }
        return count;
    }
}