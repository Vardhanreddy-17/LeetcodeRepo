class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0;
        int r = 0;
        while(l<g.length && r<s.length){
            if(s[r]>=g[l]){
                count++;
                l++;
            }
            r++;
        }
        return count;
    }
}