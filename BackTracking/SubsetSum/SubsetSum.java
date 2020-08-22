import java.util.*;

public class SubsetSum {

    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        visited = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        String ans = "";
        System.out.println();
        System.out.println("Answers");
        BT(arr,k,0,ans, 0);
        sc.close();
    }

    public static void BT(int[] arr, int k,int sum,String ans, int  start) {
        if(sum == k) {
            System.out.println(ans.strip());
        }
        else if(sum < k) {
            for(int i=start;i<arr.length;i++) {
                if(visited[i] != 1) {
                    visited[i] = 1;
                    BT(arr,k,sum+arr[i],ans+" "+arr[i],start + 1);
                    visited[i] = 0;
                }
            }
        }
    }
}