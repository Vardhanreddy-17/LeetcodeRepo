class Solution {
    public int minOperations(int[][] grid, int x) {
        int mod = grid[0][0]%x;
        int row = grid.length;
        int col = grid[0].length;
        int arr[] = new int[row*col];
        int i = 0;
        for(int k[]:grid){
            for(int num:k){
                if(num%x!=mod){
                    return -1;
                }
                arr[i++] = num;
            }
        }
        Arrays.sort(arr);
        int n = row*col;
        int mid = arr[n/2];
        int operation = 0;
        for(int j=0;j<arr.length;j++){
            operation+=Math.abs(arr[j]-mid);
        }
        return operation/x;
    }
}