class Solution {
    public int minBitFlips(int start, int goal) {
        int z = start^goal;
        int count = 0;
        while(z>1){
            if((z&1)==1) count++;
            z=z>>1;
        }
        if(z==1) count++;
        return count;
    }
}