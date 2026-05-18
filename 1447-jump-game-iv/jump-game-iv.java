class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n==1){
            return 0;
        }
        boolean vis[] = new boolean[n];
        HashMap<Integer,List<Integer>> mp = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        //precompute the hash map
        for(int i=0;i<n;i++){
            mp.computeIfAbsent(arr[i],v -> new ArrayList<Integer>()).add(i);
        }
        q.add(0);
        vis[0] = true;
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int cur = q.poll();
                if(cur==n-1){
                    return steps;
                }
                if(cur-1>=0 && !vis[cur-1]){
                    q.add(cur-1);
                    vis[cur-1] = true;
                }
                if(cur+1<n && !vis[cur+1]){
                    q.add(cur+1);
                    vis[cur+1] = true;
                }
                if(mp.containsKey(arr[cur])){
                    for(int index:mp.get(arr[cur])){
                        if(!vis[index]){
                            q.add(index);
                            vis[index] = true;
                        }
                    }
                    mp.remove(arr[cur]);
                }
            }
            steps++;
        }
        return -1;
    }
}