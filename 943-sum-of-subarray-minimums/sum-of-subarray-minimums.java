class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = 1000000007;
        long ans = 0;
        int[] nse = new int[n];
        int[] pse = new int[n];
        findNSE(arr,nse,n);
        findPSE(arr,pse,n);
        for(int i=0;i<n;i++){
            long left = i - pse[i];
            long right = nse[i] - i;
            long contri = (((left*right)%mod)*arr[i])%mod;
            ans = (ans+contri)%mod;
        }
        return (int)ans;
    }
    // Next Smaller or Equal Element
    public void findNSE(int[] arr, int[] nse, int n) {
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }
    }

    // Previous Strictly Smaller Element
    public void findPSE(int[] arr, int[] pse, int n) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }
    }
}