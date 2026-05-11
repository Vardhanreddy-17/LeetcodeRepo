class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            String s = String.valueOf(nums[i]);
            for(int j=0;j<s.length();j++){
                int num = s.charAt(j)-'0';
                ans.add(num);
            }
        }
        int arr[] = new int[ans.size()];
        int i =0;
        for(int num:ans){
            arr[i++] = num;
        }
        return arr;
    }
}