import java.util.*;

class Kosaraju
{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(v);
        for(int i=0;i<v;i++){
            list.add(new ArrayList<Integer>());
        }
        for(int i=0;i<e;i++){
            int startVertex = sc.nextInt();
            int endVertex = sc.nextInt();
            list.get(startVertex).add(endVertex);
        }
        System.out.println(kosarajuF(list,v));
        sc.close();
    }

    static int kosarajuF(ArrayList<ArrayList<Integer>> adj, int N)
    {
        // dfs <
        // dfs complete <
        // transpose <
        // dfsK <
        Deque <Integer> dq = new ArrayDeque<>();
        dq = dfsComplete(adj, N, dq);
        ArrayList<ArrayList<Integer>> adjTranspose = transpose(adj);
        return dfsK(adjTranspose, N, dq);
    }
    
    static int dfsK(ArrayList<ArrayList<Integer>> g, int N, Deque <Integer> dq) {
        int count = 0;
        boolean[] visited = new boolean[N];
        while(dq.size() > 0) {
            int start = dq.pollLast();
            if(visited[start] == false) {
                count++;
                ArrayList<Integer> answer = dfs(g, N, visited, start);
                System.out.println(answer);
            }
        }
        return count;
    }
    
    static Deque<Integer> dfsComplete(ArrayList<ArrayList<Integer>> g, int N, Deque <Integer> dq) {
        boolean[] visited = new boolean[N];
        while(dq.size() < N) {
            int start = getStart(visited);
            ArrayList<Integer> answer = dfs(g, N, visited, start);
            for(Integer i: answer) {
                dq.add(i);
            }
        }
        return dq;
    }
    
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N, boolean[] visited,int start)
    {
        ArrayList<Integer> answer = new ArrayList<>();
        search(g, visited, answer, start);
        return answer;
    }
    
    static void search(ArrayList<ArrayList<Integer>> g, boolean[] visited, ArrayList<Integer> answer, int element) {
            
            visited[element] = true;
            
            ArrayList<Integer> curr = g.get(element);
            
            for(int i=0;i<curr.size();i++) {
                if(visited[curr.get(i)] == false){
                    search(g, visited, answer, curr.get(i));
                }
            }
            
            answer.add(element);
    }
    
    static int getStart(boolean[] visited) {
        for(int i=0;i<visited.length;i++) {
            if(visited[i] == false) {
                return i;
            }
        }
        return -1;
    }
    
    static ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>(adj.size());
        for(int i = 0;i<adj.size();i++) {
            transpose.add(new ArrayList<Integer>());
        }
        for(int i=0;i<adj.size();i++) {
            ArrayList<Integer> curr = adj.get(i);
            for(Integer index: curr) {
                transpose.get(index).add(i);
            }
        }
        return transpose;
    }
}