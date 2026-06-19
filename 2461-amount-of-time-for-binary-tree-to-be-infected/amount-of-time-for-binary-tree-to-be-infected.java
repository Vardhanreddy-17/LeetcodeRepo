/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        if(root==null){
            return 0;
        }
        Map<TreeNode,TreeNode> mp = new HashMap<>();
        TreeNode target = findNode(root,start,mp);
        Map<TreeNode,Boolean> vis = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        int count = 0;
        q.add(target);
        vis.put(target,true);
        while(!q.isEmpty()){
            int s = q.size();
            count++;
            for(int i=0;i<s;i++){
                TreeNode temp = q.poll();
                if(temp.left!=null && vis.get(temp.left)==null){
                    q.add(temp.left);
                    vis.put(temp.left,true);
                }
                if(temp.right!=null && vis.get(temp.right)==null){
                    q.add(temp.right);
                    vis.put(temp.right,true);
                }
                if(mp.get(temp)!=null && vis.get(mp.get(temp))==null){
                    q.add(mp.get(temp));
                    vis.put(mp.get(temp),true);
                }
            }
        }
        return count-1;
    }
    public TreeNode findNode(TreeNode root,int start,Map<TreeNode,TreeNode> mp){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode target = null;
        while(!q.isEmpty()){
            int s = q.size();
            for(int i=0;i<s;i++){
                TreeNode temp = q.poll();
                if(temp.val==start){
                    target = temp;
                }
                if(temp.left!=null){
                    mp.put(temp.left,temp);
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    mp.put(temp.right,temp);
                    q.add(temp.right);
                }
            }
        }
        return target;
    }
}