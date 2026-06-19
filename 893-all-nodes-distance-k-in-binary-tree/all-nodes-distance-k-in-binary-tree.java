/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Map<TreeNode,TreeNode> mp = new HashMap<>();
        markParent(root,mp);
        Map<TreeNode,Boolean> vis = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        int distance = 0;
        vis.put(target,true);
        while(!q.isEmpty()){
            int s = q.size();
            if(distance==k){
                break;
            }
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
            distance++;
        }
        while(!q.isEmpty()){
            res.add(q.poll().val);
        }
        return res;
    }
    public void markParent(TreeNode root,Map<TreeNode,TreeNode> mp){
        if(root==null){
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s = q.size();
            for(int i=0;i<s;i++){
                TreeNode temp = q.poll();
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
        return;
    }
}