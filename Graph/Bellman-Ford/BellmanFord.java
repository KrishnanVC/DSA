import java.util.*;
import java.lang.*;
import java.io.*;

class BellmanFord {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int V = sc.nextInt();
		    int E = sc.nextInt();
			int[] weights = new int[V];
		    
		    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		    for(int i=0;i<E;i++) {
		        ArrayList<Integer> list = new ArrayList<>();
		        list.add(sc.nextInt());
		        list.add(sc.nextInt());
		        list.add(sc.nextInt());
		        graph.add(list);
		    }
		    befo(graph,weights,0);
		    System.out.println(Arrays.toString(weights));
        }
        sc.close();
	}

	// Bellmond Ford Algorithm
	static void befo(ArrayList<ArrayList<Integer>> graph, int[] weights, int source) {
		initialize(weights, source);
	    int n = weights.length - 1;
	    int E = graph.size();
	    while(n-- > 0) {
	        int flag = 0;
	        for(int i=0;i<E;i++) {
	            ArrayList<Integer> curr = graph.get(i);
				if(weights[curr.get(0)] != Integer.MAX_VALUE && (weights[curr.get(0)] + curr.get(2)) < weights[curr.get(1)]) {
					flag = 1;
					weights[curr.get(1)] = weights[curr.get(0)] + curr.get(2);
				}
	        }
	        if(flag == 0) {
	            break;
	        }
	    }
	}

	static void initialize(int[] weights, int source) {
        for(int i = 0;i<weights.length;i++) {
			weights[i] = Integer.MAX_VALUE;
		}
		weights[source] = 0;
	}
	

	// For checking Negative cycles in a graph

	static int check(ArrayList<ArrayList<Integer>> graph, int[] weights) {
	    
	    int E = graph.size();
	    for(int i=0;i<E;i++) {
            ArrayList<Integer> curr = graph.get(i);
			if((weights[curr.get(0)] + curr.get(2)) < weights[curr.get(1)]) {
				return 1;
			}
        }
        return 0;
	} 
}