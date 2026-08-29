class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int leftmax = Integer.MIN_VALUE;
        int rightmax = Integer.MIN_VALUE;
        int ans = 0;
        while(left<right){
            if(height[left]<=height[right]){
                if(leftmax<height[left]){
                    leftmax = height[left];
                }else{
                    ans+=leftmax-height[left];
                }
                left++;
            }else{
                if(rightmax<height[right]){
                    rightmax = height[right];
                }else{
                    ans+=rightmax - height[right];
                }
                right--;
            }
        }
        return ans;
    }
}