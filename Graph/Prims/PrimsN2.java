class MST {
    static int spanningTree(int V, int E, ArrayList<ArrayList<Integer>> graph) {

        // Initializing the weights matrix with large values

        int[] weights = new int[V];
        weights[0] = 0;
        for(int i=1;i<V;i++){
            weights[i] = Integer.MAX_VALUE;
        }

        Set<Integer> set = new HashSet<>();

        while(set.size() < V){
            int curr = getMin(weights,set);
            set.add(curr);
            ArrayList<Integer> vertices = graph.get(curr);

            // Update the weights of the vertices that are adjacent to the tree set

            for(int i = 0;i<vertices.size();i++){
                if(vertices.get(i) < weights[i] && !set.contains(i)) {
                    weights[i] = vertices.get(i);
                }
            }

        }

        int sum = getSum(weights);
        return sum;

    }

    // Function that returns the minimum index that is not in tree set
    
    static int getMin(int[] weights, Set<Integer> set) {
        int min = Integer.MAX_VALUE;
        int pos = -1;
        for(int i=0;i<weights.length;i++){
            if(weights[i] < min && !set.contains(i)) {
                min = weights[i];
                pos = i;
            }
        }
        return pos;
    }

    // Function returns sum of the array
    
    static int getSum(int[] weights) {
        int sum = 0;
        for(int i=0;i<weights.length;i++){
            sum += weights[i];
        }
        return sum;
    }
}
