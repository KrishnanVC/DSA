import java.util.*;

class Traversal {
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int N) {
        int[] isVisited = new int[N];
        Deque<Integer> dq = new ArrayDeque<>();
        ArrayList<Integer> answer = new ArrayList<>();
        dq.push(0);
        while(dq.size() > 0){
            
            int head = dq.pollFirst();
            if(isVisited[head] != 1){
                isVisited[head] = 1;
                answer.add(head);
                ArrayList<Integer> curr = g.get(head);
                for(int i=0;i<curr.size();i++){
                    if(isVisited[curr.get(i)] == 0){
                        dq.add(curr.get(i));
                    }
                }
            }
            
        }
        return answer;
    }
}