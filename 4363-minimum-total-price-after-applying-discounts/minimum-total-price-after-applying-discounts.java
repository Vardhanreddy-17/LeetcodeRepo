class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int priceslen = prices.length;
        int discountlen = discounts.length;
        int j = discountlen - 1;
        int i = priceslen - 1;
        double sum = 0;
        while(j>=0 && i>=0){
            sum+= (double)prices[i]*(100 - discounts[j])/100;
            i--;
            j--;
        }
        for(int k=0;k<=i;k++){
            sum+=prices[k];
        }
        return sum;
    }
}