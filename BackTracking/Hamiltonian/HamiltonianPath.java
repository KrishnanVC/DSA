/*package whatever //do not write package name here */

import java.util.*;

public class HamiltonianPath {
    
    static boolean[] visited = new boolean[10];
    
    public static int BT(ArrayList<ArrayList<Integer>> graph,int count,int n,int curr) {
        if(count == n) {
            return 1;
        }
        else {
            ArrayList<Integer> list = graph.get(curr);
            for(int i = 0;i<list.size();i++) {
                if(visited[list.get(i)] != true) {
                    visited[list.get(i)] = true;
                    if(BT(graph,count+1,n,list.get(i)) == 1) {
                        return 1;
                    }
                    visited[list.get(i)] = false;
                }
            }
            return 0;
        }
    }
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); sc.nextLine();
        while(t-- > 0) {
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            int n = sc.nextInt();
            for(int i=0;i<n;i++) {
                graph.add(new ArrayList<>());
            }
            int m = sc.nextInt();
            for(int i=0;i<m;i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                ArrayList<Integer> list = graph.get(u - 1);
                list.add(v - 1);
                graph.set(u - 1,list);
                list = graph.get(v - 1);
                list.add(u - 1);
                graph.set(v - 1,list);
            }
            int ans = 0;
            for(int i=0;i<n;i++) {
                visited = new boolean[n];
                visited[i] = true;
                ans = BT(graph,1,n,i);
                if(ans == 1) {
                    break;
                }
            }
            System.out.println(ans);
        }
        sc.close();
	}
}