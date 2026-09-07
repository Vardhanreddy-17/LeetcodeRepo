class Solution {
    public int largestRectangleArea(int[] nums) {
        int n = nums.length;
        int pse[] = new int[n];
        int nse[] = new int[n];
        findPSE(nums,pse,n);
        findNSE(nums,nse,n);
        int maxArea = 0;
        int area = 0;
        for(int i=0;i<n;i++){
            area = nums[i]*(nse[i]-pse[i]-1);
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
    public void findPSE(int[] nums,int[] pse,int n){
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }
            pse[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
    }
    public void findNSE(int[] nums,int nse[],int n){
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            nse[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }
    }
}