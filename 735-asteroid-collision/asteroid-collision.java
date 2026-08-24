class Solution {
    public int[] asteroidCollision(int[] ast) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<ast.length;i++){
            if(ast[i]>0){
                st.push(ast[i]);
            }else{
                while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(ast[i])){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek()==Math.abs(ast[i])) st.pop();
                else if(st.isEmpty() || st.peek()<0){
                    st.push(ast[i]);
                }
            }
        }
        int arr[] = new int[st.size()];
        for(int i=arr.length-1;i>=0;i--){
            arr[i] = st.pop();
        }
        return arr;
    }
}