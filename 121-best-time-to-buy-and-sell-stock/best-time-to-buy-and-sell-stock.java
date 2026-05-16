class Solution {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprice = Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            minprice = Math.min(minprice,prices[i]);
            maxprice = Math.max(maxprice,prices[i]-minprice);
        }
        return maxprice;
    }
}