class Solution {
    public int divide(int n, int d) {
        if(d == n) return 1;
        if(n == Integer.MIN_VALUE && d == -1) return Integer.MAX_VALUE;
        if(d == 1) return n;
        boolean sign = true;
        if(n<0 && d>0) sign = false;
        if(n>0 && d<0) sign = false;
        long dividend = Math.abs((long)n);
        long divisor = Math.abs((long)d);
        int ans = 0;
        while(dividend>=divisor){
            int count = 0;
            while(dividend>=(divisor<<count+1)){
                count++;
            }
            ans+=(1<<count);
            System.out.println(ans);
            dividend -= divisor<<count;
        }
        if(ans==(1<<31) && sign==true) return Integer.MAX_VALUE;
        if(ans==(1<<31) && sign==false) return Integer.MIN_VALUE;
        return sign?ans:-ans;
    }
}