import java.util.*;

public class Transpose {

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
        ArrayList<ArrayList<Integer>> transposeList = transpose(list);
        for(int i=0;i<transposeList.size();i++){
            System.out.print(i);
            for(int j = 0;j<transposeList.get(i).size();j++){
                System.out.print("->" + transposeList.get(i).get(j));
            }
            System.out.println();
        }
        sc.close();
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