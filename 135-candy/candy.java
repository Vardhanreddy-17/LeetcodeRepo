class Solution {
    public int candy(int[] ratings) {
        int sum = 1;
        int i = 1;
        int n = ratings.length;
        while(i<n){
            while(i<n && ratings[i]==ratings[i-1]){
                i++;
                sum+=1;
            }
            int peek = 1;
            while(i<n && ratings[i]>ratings[i-1]){
                i++;
                peek++;
                sum+=peek;
            }
            int down = 1;
            while(i<n && ratings[i]<ratings[i-1]){
                i++;
                sum+=down;
                down++;
            }
            if(down>peek){
                sum+=(down-peek);
            }
        }
        return sum;
    }
}