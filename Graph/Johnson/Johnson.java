import java.util.*;

public class Johnson {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int[] weights = new int[V + 1];
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<E;i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(sc.nextInt());
            list.add(sc.nextInt());
            list.add(sc.nextInt());
            graph.add(list);
        }
        for(int i=0;i<V;i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(V);
            list.add(i);
            list.add(0);
            graph.add(list);
        }
    
        johnsonF(graph, weights, V, E);
        
        sc.close();
    }

    static void johnsonF(ArrayList<ArrayList<Integer>> graph, int[] weights, int V, int E) {
        befo(graph,weights,V);
        update(graph, weights);
        remove(graph,V);
        ArrayList<ArrayList<ArrayList<Integer>>> graphList = new ArrayList<>(V);
        graphToList(graphList, graph, V); 
        dijkstraDriver(V, E, graphList);
    }

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
    
    static void update(ArrayList<ArrayList<Integer>> graph, int[] weights) {
        for(int i=0;i<graph.size();i++) {
            ArrayList<Integer> graphVertex = graph.get(i); 
            int u = graphVertex.get(0);
            int v = graphVertex.get(1);
            int w = graphVertex.get(2);

            w = w + weights[u] - weights[v];

            graphVertex.set(2,w);
            graph.set(i,graphVertex);
        }
    }

    static void remove(ArrayList<ArrayList<Integer>> graph, int addition) {
        for(int i=0;i<graph.size();i++) {
            ArrayList<Integer> graphVertex = graph.get(i); 
            if(graphVertex.get(0) == addition) {
                graph.remove(i);
                i--;
            }
        }
    }

    static void graphToList(ArrayList<ArrayList<ArrayList<Integer>>> graphList, ArrayList<ArrayList<Integer>> graph, int V) {
        for(int i=0;i<V;i++) {
            graphList.add(new ArrayList<ArrayList<Integer>>());
        }

        for(int i=0;i<graph.size();i++) {
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<Integer> edge = graph.get(i);
            list.add(edge.get(1));
            list.add(edge.get(2));
            ArrayList<ArrayList<Integer>> listOfList = graphList.get(edge.get(0));
            listOfList.add(list);
            graphList.set(edge.get(0),listOfList);
        }
    }

    static void dijkstraDriver(int V, int E, ArrayList<ArrayList<ArrayList<Integer>>> graph) {
        for(int i=0;i<V;i++) {
            int[] weights = dijkstraF(V, E, graph, i);
            System.out.println("From " + i);
            System.out.println(Arrays.toString(weights));
            System.out.println();
        }
    }

    static int[] dijkstraF(int V, int E, ArrayList<ArrayList<ArrayList<Integer>>> graph, int start) {

        // Initializing the weights matrix with large values

        int[] weights = new int[V];

        for(int i=0;i<V;i++){
            weights[i] = Integer.MAX_VALUE;
        }

        
        weights[start] = 0;

        Set<Integer> set = new HashSet<>();

        while(set.size() < V){
            int curr = getMin(weights,set);
            set.add(curr);
            ArrayList<ArrayList<Integer>> vertices = graph.get(curr);

            // Update the weights of the vertices that are adjacent to the tree set

            for(int i = 0;i<vertices.size();i++){
                ArrayList<Integer> vertex = vertices.get(i);
                if(vertex.get(1) + weights[curr] < weights[vertex.get(0)] && !set.contains(vertex.get(0))) {
                    weights[vertex.get(0)] = vertex.get(1) + weights[curr];
                }
            }

        }
        
        return weights;

    }

    // Function that returns the minimum index that is not in tree set

    static int getMin(int[] weights, Set<Integer> set) {
        int min = Integer.MAX_VALUE;
        int pos = -1;
        for(int i=0;i<weights.length;i++){
            if(weights[i] <= min && !set.contains(i)) {
                min = weights[i];
                pos = i;
            }
        }
        return pos;
    }
	
}