class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        int left = 0;
        int right = 0;
        int n = s.length();
        int max = 0;
        while(right<n && left<n){
            char ch = s.charAt(right);
            if(mp.containsKey(ch)){
                if(mp.get(ch)<left){
                    mp.put(ch,right);
                }else{
                    left = mp.get(ch)+1;
                }
            }
            mp.put(ch,right);
            max = Math.max(max,right-left+1);
            right = right+1;
        }
        return max;
    }
}