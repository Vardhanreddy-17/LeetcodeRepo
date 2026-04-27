class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        sumUp(candidates,target,0,0,candidates.length,res,ans);
        return ans;
    }
    public void sumUp(int[] candidates,int target,int sum,int index,int n,List<Integer> res,List<List<Integer>> ans){
        if(sum==target){
            ans.add(new ArrayList<>(res));
            return;
        }
        if(index==n||sum>target){
            return;
        }
        res.add(candidates[index]);
        sumUp(candidates,target,sum+candidates[index],index,n,res,ans);
        res.remove(res.size()-1);
        sumUp(candidates,target,sum,index+1,n,res,ans);
    }
}