class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        subSetHelper(nums,0,nums.length,inner,ans);
        return ans;
    }
    public void subSetHelper(int[] nums,int ind,int size,List<Integer> inner,List<List<Integer>> ans){
        if(ind==size){
            ans.add(new ArrayList<>(inner));
            return;
        }
        subSetHelper(nums,ind+1,size,inner,ans);
        inner.add(nums[ind]);
        subSetHelper(nums,ind+1,size,inner,ans);
        inner.remove(inner.size()-1);
    }
}