class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int left = 0;
        int right = 0;
        int n = nums1.length;
        int m = nums2.length;
        while(left<n && right<m){
            if(nums1[left]<nums2[right]){
                left++;
            }else if(nums1[left]>nums2[right]){
                right++;
            }else{
                return nums1[left];
            }
        }
        return -1;
    }
}