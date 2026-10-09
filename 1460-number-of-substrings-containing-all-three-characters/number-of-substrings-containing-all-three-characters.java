class Solution {
    public int numberOfSubstrings(String s) {
        int arr[] = new int[3];
        int count = 0;
        Arrays.fill(arr,-1);
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a'] = i;
            count+= 1+Math.min(arr[0],Math.min(arr[1],arr[2]));
        }
        return count;
    }
}