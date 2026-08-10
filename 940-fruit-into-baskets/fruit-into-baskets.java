class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> mp = new HashMap<>();
        int l = 0;
        int r = 0;
        int n = fruits.length;
        int maxFruits = 0;
        int max = 0;
        while(l<n && r<n){
            mp.put(fruits[r],mp.getOrDefault(fruits[r],0)+1);
            if(mp.size()>2){
                if(mp.get(fruits[l])>1){
                    mp.put(fruits[l],mp.get(fruits[l])-1);
                }else{
                    mp.remove(fruits[l]);
                }
                l++;
            }
            if(mp.size()<=2) maxFruits = Math.max(maxFruits,r-l+1);
            r++;
        }
        return maxFruits;
    }
}