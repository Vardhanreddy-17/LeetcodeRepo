class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Arrays.sort(candidates);
        comb(candidates,target,0,res,ans);
        return ans;
    }
    public void comb(int[] nums,int target,int index,List<Integer> res,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(res));
            return;
        }
        if(index==nums.length || target<0){
            return;
        }
        res.add(nums[index]);
        comb(nums,target-nums[index],index+1,res,ans);
        res.remove(res.size()-1);
        for(int j=index+1;j<nums.length;j++){
            if(nums[j]!=nums[index]){
                comb(nums,target,j,res,ans);
                break;
            }
        }
    }
}