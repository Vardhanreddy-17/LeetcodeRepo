class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i=0;i<nums.length;i++){
            xor = xor^nums[i];
        }
        int rightMostBits = (xor&(xor-1))^xor;
        int b1 = 0;
        int b2 = 0;
        for(int i=0;i<nums.length;i++){
            if((rightMostBits&nums[i])==0) b1 ^= nums[i];
            else b2 ^= nums[i];
        }
        return b1<b2?new int[]{b1,b2}:new int[]{b2,b1};
    }
}