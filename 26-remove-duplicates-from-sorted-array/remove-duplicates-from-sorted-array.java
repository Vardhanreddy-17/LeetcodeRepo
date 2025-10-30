class Solution {
    public int removeDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        res.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(i!=0 && nums[i]!=nums[i-1]){
                res.add(nums[i]);
            }
        }
        for(int i=0;i<res.size();i++){
            nums[i] = res.get(i);
        }
        return res.size();
    }
}