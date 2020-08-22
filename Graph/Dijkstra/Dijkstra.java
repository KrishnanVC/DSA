import java.util.*;

class Dijkstra {

    public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int V = sc.nextInt();
		    int E = sc.nextInt();
		    
            ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<>();
            
            for(int i=0;i<V;i++) {
                graph.add(new ArrayList<>());
            }

		    for(int i=0;i<E;i++) {
		        ArrayList<Integer> list = new ArrayList<>();
		        int source = sc.nextInt();
		        list.add(sc.nextInt());
                list.add(sc.nextInt());
                ArrayList<ArrayList<Integer>> listOfList= graph.get(source);
                listOfList.add(list);
		        graph.set(source, listOfList);
		    }
		    int[] weights = dijkstraF(V, E, graph,0);
            System.out.println(Arrays.toString(weights));
        }
        sc.close();
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