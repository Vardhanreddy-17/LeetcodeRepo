class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack();
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--){
            while(!st.isEmpty() &&st.peek()<nums2[i]){
                st.pop();
            }
            if(!st.isEmpty() && st.peek()>nums2[i]){
                mp.put(nums2[i],st.peek());
                st.push(nums2[i]);
            }
            if(st.isEmpty()){
                st.push(nums2[i]);
                mp.put(nums2[i],-1);
            }
        }
        int hash[] = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            hash[i] = mp.get(nums1[i]);
        }
        return hash;
    }
}