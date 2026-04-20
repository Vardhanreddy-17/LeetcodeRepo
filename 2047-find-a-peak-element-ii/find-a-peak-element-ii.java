class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int rowL = mat.length;
        int colL = mat[0].length;
        int low = 0;
        int high = colL-1;
        while(low<=high){
            int mid = (low+high)/2;
            int row = findmax(mat,rowL,colL,mid);
            int left = mid-1>=0?mat[row][mid-1]:-1;
            int right = mid+1<colL?mat[row][mid+1]:-1;
            if(left<mat[row][mid] && right<mat[row][mid]){
                return new int[]{row,mid};
            }if(left>mat[row][mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }
    public int findmax(int[][] mat,int rowL,int colL,int mid){
        int index = -1;
        int largest = -1;
        for(int i=0;i<rowL;i++){
            if(mat[i][mid]>largest){
                largest = mat[i][mid];
                index = i;
            }
        }
        return index;
    }
}