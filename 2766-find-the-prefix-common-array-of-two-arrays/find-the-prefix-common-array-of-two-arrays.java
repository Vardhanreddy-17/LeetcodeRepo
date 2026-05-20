class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int ans[] = new int[A.length+1];
        int arr[] = new int[A.length];
        for(int i=0;i<A.length;i++){
            ans[A[i]]++;
            ans[B[i]]++;
            int count = 0;
            for(int j=0;j<ans.length;j++){
                if(ans[j]==2){
                    count++;
                }
            }
            arr[i] = count;
        }
        return arr;
    }
}