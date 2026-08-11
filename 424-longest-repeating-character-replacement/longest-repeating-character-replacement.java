class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        Map<Character,Integer> mp = new HashMap<>();
        int l = 0;
        int r = 0;
        int n = s.length();
        int maxfreq = 0;
        while(l<n && r<n){
            char leftch = s.charAt(l);
            char rightch = s.charAt(r);
            mp.put(rightch,mp.getOrDefault(rightch,0)+1);
            maxfreq = Math.max(maxfreq,mp.get(rightch));
            if((r-l+1)-maxfreq>k){
                mp.put(leftch,mp.get(leftch)-1);
                if(mp.get(leftch)==0) mp.remove(leftch);
                l++;
            }
            if((r-l+1)-maxfreq<=k) maxLen = Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen;
    }
}