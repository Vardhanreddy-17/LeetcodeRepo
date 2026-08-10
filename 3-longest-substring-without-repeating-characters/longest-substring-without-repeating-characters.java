class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        int left = 0;
        int right = 0;
        int n = s.length();
        int max = 0;
        while(right<n && left<n){
            char ch = s.charAt(right);
            while(mp.containsKey(ch)){
                mp.remove(s.charAt(left));
                left++;
            }
            mp.put(ch,right);
            max = Math.max(max,mp.size());
            right = right+1;
        }
        return max;
    }
}