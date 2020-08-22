class Traversal
{
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N)
    {
        boolean[] visited = new boolean[N];
        ArrayList<Integer> answer = new ArrayList<>();
        search(g, visited, answer, 0);
        return answer;
    }
    
    static void search(ArrayList<ArrayList<Integer>> g, boolean[] visited, ArrayList<Integer> answer, int element) {
            
            visited[element] = true;
            answer.add(element);
            
            ArrayList<Integer> curr = g.get(element);
            
            for(int i=0;i<curr.size();i++) {
                if(visited[curr.get(i)] == false){
                    search(g, visited, answer, curr.get(i));
                }
            }
    }
}
