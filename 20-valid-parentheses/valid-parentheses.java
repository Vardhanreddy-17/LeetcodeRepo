class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        boolean isValid = true;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='[') st.push(ch);
            else if(st.isEmpty()|| (ch==')'&& st.peek()!='(')||(ch=='}' && st.peek()!='{') || (ch==']' && st.peek()!='[')){
                isValid = false;
                break;
            }else{
                st.pop();
            }
        }
        return isValid==true?st.isEmpty():false;
    }
}