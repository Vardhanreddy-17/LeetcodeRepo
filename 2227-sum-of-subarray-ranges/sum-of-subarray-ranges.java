class Solution {
    public long subArrayRanges(int[] nums) {
        return subArrayMaximums(nums) - subArrayMinimums(nums);
    }
    public long subArrayMinimums(int[] nums){
        int n = nums.length;
        int nse[] = new int[n];
        int pse[] = new int[n];
        NSE(nums,nse,n);
        PSE(nums,pse,n);
        long sum = 0;
        for(int i=0;i<n;i++){
            long left = nse[i] - i;
            long right = i - pse[i];
            long contri = (left*right)*nums[i];
            sum = sum+contri;
        }
        return sum;
    }
    public void NSE(int[] nums,int[] nse,int n){
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }
            nse[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }
    }
    public void PSE(int[] nums,int[] pse,int n){
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            pse[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
    }
    public long subArrayMaximums(int[] nums){
        int n = nums.length;
        int nge[] = new int[n];
        int pge[] = new int[n];
        NGE(nums,nge,n);
        PGE(nums,pge,n);
        long sum = 0;
        for(int i=0;i<n;i++){
            long left = nge[i] - i;
            long right = i - pge[i];
            long contri = (left*right)*nums[i];
            sum = sum+contri;
        }
        return sum;
    }
    public void NGE(int[] nums,int[] nge,int n){
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                st.pop();
            }
            nge[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }
    }
    public void PGE(int[] nums,int[] pge,int n){
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                st.pop();
            }
            pge[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
    }
}