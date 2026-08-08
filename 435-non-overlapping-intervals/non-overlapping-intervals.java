class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int row = intervals.length;
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[1],b[1]));
        int end = Integer.MIN_VALUE;
        int count = 0;
        for(int i=0;i<row;i++){
            int s = intervals[i][0];
            int e = intervals[i][1];
            if(s>=end){
                end = e;
            }else{
                count++;
            }
        }
        return count;
    }
}