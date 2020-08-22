package EqualPartition;

import java.util.*;

public class EqualPartition {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-- > 0) {
	        int n = sc.nextInt();
	        int sum = 0;
	        int[] arr = new int[n];
	        for(int i=0;i<n;i++) {
	            arr[i] = sc.nextInt();
	            sum += arr[i];
	        }
	        int k = sum/2;
	        if(sum %2 == 1) {
	            System.out.println("NO");
	        }
	        else {
	            if(subsetSum(arr,k) == 1) {
	                System.out.println("YES");
	            }
	            else {
	                System.out.println("NO");
	            }
	        }
        }
        sc.close();
	}
	
	public static int subsetSum(int[] arr, int k) {
	    int[][] dp = new int[arr.length][k+1];
	    for(int i=0;i<arr.length;i++) {
	        for(int j=0;j<=k;j++) {
	            if(i == 0 || j == 0) {
	                if(i == 0) {
	                   if(j == arr[i])
	                      dp[i][j] = 1;
	                   else
	                      dp[i][j] = 0;
	                }
	                if(j == 0)
	                   dp[i][j] = 1;
	            }
	            else {
	                if(j >= arr[i])
	                    dp[i][j] = dp[i-1][j - arr[i]] | dp[i-1][j];
	                else
	                    dp[i][j] = dp[i-1][j];
	            }
	        }
	    }
	    
	   // for(int i=0;i<arr.length;i++) {
	   //     for(int j = 0;j<=k;j++) {
	   //         System.out.print(dp[i][j] + " ");
	   //     }
	   //     System.out.println();
	   // }
	    return dp[arr.length-1][k];
	}
}