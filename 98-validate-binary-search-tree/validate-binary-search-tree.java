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
    public long prev = Long.MIN_VALUE;
    public long present = Long.MIN_VALUE;
    public boolean check = true;
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        return check;
    }
    public void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        prev = present;
        present = root.val;
        if(prev>=present){
            check = false;
        }
        inOrder(root.right);
        return;
    }
}