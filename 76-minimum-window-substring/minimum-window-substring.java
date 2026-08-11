class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<t.length();i++){
            mp.put(t.charAt(i),mp.getOrDefault(t.charAt(i),0)+1);
        }
        int min = Integer.MAX_VALUE;
        int startIndex = -1;
        int l = 0;
        int r = 0;
        int count = 0;
        while(l<s.length() && r<s.length()){
            if(mp.containsKey(s.charAt(r)) && mp.get(s.charAt(r))>0){
                count++;
            }
            mp.put(s.charAt(r),mp.getOrDefault(s.charAt(r),0)-1);
            while(count==t.length()){
                if((r-l+1)<min){
                    min = r-l+1;
                    startIndex = l;
                }
                if(mp.get(s.charAt(l))+1>0) count--;
                mp.put(s.charAt(l),mp.get(s.charAt(l))+1);
                l++;
            }
            r++;
        }
        return startIndex==-1?"":s.substring(startIndex,startIndex+min);
    }
}