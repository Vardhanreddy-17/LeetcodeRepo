class Solution {
    public String removeKdigits(String nums, int k) {
        Stack<Character> st = new Stack<>();
        if(k>=nums.length()){
            return "0";
        }
        for(int i=0;i<nums.length();i++){
            while(!st.isEmpty() && k>0 && st.peek()-'0'>nums.charAt(i)-'0'){
                st.pop();
                k--;
            }
            st.push(nums.charAt(i));
        }
        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.peek());
            st.pop();
        }
        int j =sb.length()-1;
        for(int i=sb.length()-1;i>=0;i--){
            if(sb.charAt(i)=='0'){
                j--;
            }else{
                break;
            }
        }
        if(j==-1){
            return "0";
        }
        sb.delete(j+1, sb.length());
        return sb.reverse().toString();
    }
}