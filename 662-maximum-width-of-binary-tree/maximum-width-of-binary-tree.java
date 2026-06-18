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
    class Pair{
        int index;
        TreeNode node;
        public Pair(int index,TreeNode node){
            this.index = index;
            this.node = node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().index;
            int first = 0;
            int last = 0;
            for(int i=0;i<size;i++){
                Pair p = q.poll();
                TreeNode node = p.node;
                int index = p.index-min;
                if(i==0){
                    first = index;
                }
                if(i==size-1){
                    last = index;
                }
                if(node.left!=null){
                    q.add(new Pair(2*index+1,node.left));
                }
                if(node.right!=null){
                    q.add(new Pair(2*index+2,node.right));
                }
            }
            max = Math.max(max,last-first+1);
        }
        return max;
    }
}