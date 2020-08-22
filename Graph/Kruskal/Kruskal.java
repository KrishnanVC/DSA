import java.util.*;

public class Kruskal {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int[][] graph = new int[E][];
        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        for(int i=0;i<E;i++){
            int source = sc.nextInt() - 1;
            int destination = sc.nextInt() - 1;
            int weight = sc.nextInt();
            graph[i] = new int[]{source,destination,weight};
        }

        // Sort the graph based on weights

        Arrays.sort(graph, (a,b) -> a[2]-b[2]);

        ArrayList<ArrayList<Integer>> answer = kruskal(graph, parent);

        print(answer);
        sc.close();
    }

    // Function for kruskal

    static ArrayList<ArrayList<Integer>> kruskal(int[][] graph, int[] parent) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

        for(int[] i: graph) {
            int parentUIndex = getParent(parent, i[0]);
            int parentVIndex = getParent(parent, i[1]);
            int parentUValue = parent[parentUIndex];
            int parentVValue = parent[parentVIndex];

            // Check if the parent of U and V are same or if they both are -1
            // If the both are -1 if means that they are apearing for the first time so allow them

            if((parentUIndex != parentVIndex) || (parentUValue == -1 && parentVValue == -1)) {

                union(parent, parentUIndex, parentVIndex, i[0]);

                ArrayList<Integer> list = new ArrayList<>();
                for(int value: i){
                    list.add(Integer.valueOf(value));
                }

                answer.add(list);
            }
        }

        return answer;
    }

    // Function to get the parent

    static int getParent(int[] parent, int curr) {
        int index = curr;
        while(parent[index] >= 0) {
            index = parent[index];
        }
        return index;
    }

    // Union Function

    static void union(int[] parent, int u, int v, int curr) {
        if(parent[u] <= parent[v]) {
            parent[u] += parent[v];
            parent[v] = u;

            /* If parent is same as the element no need to replace because it must be -1 if you replace it will be its index
               ex: 0 -> -1 u,v = -1,-1 then put v -> 0 and let u stay -1
               If we replace it we will get u -> 0 and result in infinte loop */

            if(curr != u){
                parent[curr] = u;
            }
        }
    }

    // Function to print the result

    static void print(ArrayList<ArrayList<Integer>> answer) {

        System.out.println();
        System.out.println("Answer");
        System.out.println();

        for(ArrayList<Integer> itr: answer) {
            System.out.println((itr.get(0)+1) + " -> " + (itr.get(1)+1));
        }
    }
}