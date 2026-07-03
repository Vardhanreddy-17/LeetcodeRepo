class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String max = "";
        for(int i=0;i<n;i++){
            String odd = expand(i,i+1,s);
            String even = expand(i,i,s);
            if(odd.length()>max.length()){
                max = odd;
            }
            if(even.length()>max.length()){
                max = even;
            }
        }
        return max;
    }
    public String expand(int start,int end,String s){
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start+1,end);
    }
}