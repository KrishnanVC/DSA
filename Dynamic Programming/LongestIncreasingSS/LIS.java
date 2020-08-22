package LongestIncreasingSS;

import java.util.*;

public class LIS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-- > 0) {
	        int n = sc.nextInt();
	        int[] arr = new int[n];
	        int[] dp = new int[n];
	        int max = 0;
	        for(int i=0;i<n;i++) {
	            arr[i] = sc.nextInt();
	            dp[i] = 1;
	        }
	        
	        for(int i=0;i<n;i++) {
	            for(int j = 0;j<i;j++) {
	                if(arr[j] < arr[i] && dp[j] >= dp[i]) {
	                    dp[i] = dp[j] + 1;
	                    if(dp[i] > dp[max]) {
	                        max = i;
	                    }
	                }
	            }
	        }
	        System.out.println(dp[max]);
        }
        sc.close();
    }
}