class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        if(n==1) return new int[]{-1};
        Stack<Integer> st = new Stack<>();
        int[] hash = new int[nums.length];
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums[i%n]) st.pop();
            if(!st.isEmpty() && nums[i%n]<st.peek()){
                hash[i%n] = st.peek();
                st.push(nums[i%n]);
            }
            if(st.isEmpty()){
                st.push(nums[i%n]);
                hash[i%n] = -1;
            }
        }
        return hash;
    }
}