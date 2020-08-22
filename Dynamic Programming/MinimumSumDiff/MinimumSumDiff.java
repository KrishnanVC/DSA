package MinimumSumDiff;

import java.util.*;

public class MinimumSumDiff {
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
	        int first = subsetSum(arr, k);
	        int second = sum - first;
	        System.out.println(first > second? first-second : second - first);
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
	    
        for(int j = k;j>=0;j--) {
            if(dp[arr.length - 1][j] == 1) {
                return j;
            }
        }
        return 0;
	}
}