class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int candy1 = 1;
        int candy2 = 1;
        left[0] = 1;
        right[0] = 1;
        int sum = 0;
        for(int i=1;i<n;i++){
            if(ratings[i-1]<ratings[i]){
                candy1++;
                left[i] = candy1;
            }else{
                candy1 = 1;
                left[i] = candy1;
            }
            if(ratings[n-i-1]>ratings[n-i]){
                candy2++;
                right[n-i-1] = candy2;
            }else{
                candy2 = 1;
                right[n-i-1] = candy2;
            }
        }
        for(int i=0;i<n;i++){
            if(left[i]>=right[i]){
                ratings[i] = left[i];
                sum+=ratings[i];
            }else{
                ratings[i] = right[i];
                sum+=ratings[i];
            }
        }
        return sum;
    }
}