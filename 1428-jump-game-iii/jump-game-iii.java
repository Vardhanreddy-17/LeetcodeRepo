class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean vis[] = new boolean[arr.length];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int k = q.poll();
            if(k<0 || k>=arr.length || vis[k]){
                continue;
            }
            if(arr[k]==0){
                return true;
            }
            vis[k] = true;
            q.offer(k+arr[k]);
            q.offer(k-arr[k]);
        }
        return false;
    }
}