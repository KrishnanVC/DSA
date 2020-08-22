class TopologicalSort {
    
    static int[] visited = new int[1];
    
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int N) {
        visited = new int[N];
        int[] result = new int[N];
        int node = 0;
        while(getIndex() < N){
            dfs(adj, N, result, node++);
        }
        return result;
    }
    
    static void dfs(ArrayList<ArrayList<Integer>> adj,int N,int[] result, int curr) {
        if(visited[curr] == 0){
            ArrayList<Integer> list = adj.get(curr);
            for(Integer i: list){
                dfs(adj, N, result, i);
            }
            visited[curr] = 1;
            int index = N - getIndex();
            result[index] = curr;
        }
    }
    
    static int getIndex() {
        int count = 0;
        for(int i: visited){
            count += i;
        }
        return count;
    }
}
