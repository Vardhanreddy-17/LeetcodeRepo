class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while(right<s.length()){
            char ch = s.charAt(right);
            while(mp.containsKey(s.charAt(right))){
                mp.remove(s.charAt(left));
                left++;
            }
            mp.put(ch,right);
            maxLen = Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
}