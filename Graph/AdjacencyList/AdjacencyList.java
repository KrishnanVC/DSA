import java.util.*;

class GFG {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt(); sc.nextLine();
	    for(int l = 0;l < t;l++){
	        int v = sc.nextInt();
	        int e = sc.nextInt();
	        List<ArrayList<Integer>> list = new ArrayList<>(v);
	        for(int i=0;i<v;i++){
	            list.add(new ArrayList<Integer>());
	        }
	        for(int i=0;i<e;i++){
	            int startVertex = sc.nextInt();
	            int endVertex = sc.nextInt();
	            list.get(startVertex).add(endVertex);
	            list.get(endVertex).add(startVertex);
	        }
	        for(int i=0;i<v;i++){
	            System.out.print(i);
	            for(int j = 0;j<list.get(i).size();j++){
	                System.out.print("->" + list.get(i).get(j));
	            }
	            System.out.println();
	        }
		}
		sc.close();
	}
}