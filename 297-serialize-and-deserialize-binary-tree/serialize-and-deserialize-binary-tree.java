/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            int s = q.size();
            for(int i=0;i<s;i++){
                TreeNode temp = q.poll();
                if(temp==null){
                    sb.append("#,");
                    continue;
                }else{
                    sb.append(temp.val).append(",");
                }
                q.add(temp.left);
                q.add(temp.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0){
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(",");
        if(values[0]=="#"){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        int counter = 1;
        while(!q.isEmpty()){
            int s = q.size();
            for(int i=0;i<s;i++){
                TreeNode cur = q.poll();
                if(!values[counter].equals("#")){
                    cur.left = new TreeNode(Integer.parseInt(values[counter]));
                    q.add(cur.left);
                }
                counter++;
                if(!values[counter].equals("#")){
                    cur.right = new TreeNode(Integer.parseInt(values[counter]));
                    q.add(cur.right);
                }
                counter++;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));