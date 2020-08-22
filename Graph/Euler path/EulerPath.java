import java.util.*;

public class EulerPath {

    static class Edge {
        int u;
        int v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    public static void main(String[] args) {
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
            list.get(endVertex).add(startVertex);
        }

        eulerPath(list, v , e);

        sc.close();
    }

    public static void eulerPath(ArrayList<ArrayList<Integer>> list, int V, int E) {
        int[] degree = getDegree(list);
        int start = getStart(degree);
        ArrayList<ArrayList<Integer>> set = new ArrayList<>(); 
        while(set.size() < 2 * E) {
            ArrayList<Integer> curr = list.get(start);
            int flag = 0;
            if(set.size() == 2*E - 2) {
                System.out.println(start + "-> " + curr.get(curr.size() - 2));
                break;
            }
            else {
                for(int i=0;i<curr.size();i++) {
                    Integer current = Integer.valueOf(curr.get(i)); 
                    if(! isBridge(list, start, current) && !contains(set,start,current)) {
                        flag = 1;
                        ArrayList<Integer> edge = new ArrayList<>();
                        edge.add(start);
                        edge.add(current);
                        System.out.println(start + "->" + current);
                        set.add(edge);
                        ArrayList<Integer> edgeReverse = new ArrayList<>();
                        edgeReverse.add(current);
                        edgeReverse.add(start);
                        set.add(edgeReverse);
                        start = current;
                        break;
                    }
                }
                if(flag == 0) {
                    System.out.println("Euler Path doesnt exits");
                    break;
                }
            }
        }
    }

    public static int[] getDegree(ArrayList<ArrayList<Integer>> list) {
        int[] degree = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            ArrayList<Integer> arr = list.get(i);
            degree[i] = arr.size();
        }
        return degree;
    }

    public static int getStart(int[] degree) {
        int pos = 0;
        for(int i=0;i<degree.length;i++) {
            if(degree[i] % 2 == 1) {
                return i;
            }
        } 
        return pos;
    }

    public static boolean isBridge(ArrayList<ArrayList<Integer>> list, int u, int v) {
        ArrayList<ArrayList<Integer>> tempList = new ArrayList<>();

        for(int i=0;i<list.size();i++){
            tempList.add(new ArrayList<Integer>());
        }

        for(int i=0;i<list.size();i++) {
            ArrayList<Integer> tempSource = list.get(i);
            ArrayList<Integer> tempDestination = new ArrayList<>();
            for(int j = 0;j<tempSource.size();j++) {
                Integer x = tempSource.get(j);
                tempDestination.add(x);
            }
            tempList.set(i,tempDestination);
        }

        ArrayList<Integer> arr = tempList.get(u);
       
        for(int j = 0;j<arr.size();j++) {
            if(arr.get(j) == v) {
                arr.remove(j);
                j--;
            }
        }
        tempList.set(u,arr);

        ArrayList<Integer> initialDFS = dfs(list, list.size(), u);
        ArrayList<Integer> finalDFS = dfs(tempList, tempList.size(), u);
        int countInitial = initialDFS.size();
        int countFinal = finalDFS.size();
        
        if(countInitial > countFinal) {
            return true;
        }
        else {
            return false;
        }
    }

    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N, int start)
    {
        boolean[] visited = new boolean[N];
        ArrayList<Integer> answer = new ArrayList<>();
        search(g, visited, answer, start);
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
    
    static boolean contains(ArrayList<ArrayList<Integer>> set,int start,int current) {
        for(ArrayList<Integer> temp: set) {
            if(temp.get(0) == start && temp.get(1) == current) {
                return true;
            }
        }
        return false;
    }
}