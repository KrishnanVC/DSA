package EditDistance;

import java.util.*;

public class EditDistance {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();  sc.nextLine();
		while(t-- > 0) {
		    int n = sc.nextInt();
		    int m = sc.nextInt(); sc.nextLine();
		    int[][] dp = new int[n+1][m+1];
		    String[] str = sc.nextLine().split(" ");
		    String str1 = str[0];
		    String str2 = str[1];
		    for(int i = 0;i<=n;i++) {
		        for(int j = 0;j<=m;j++) {
		            if(i==0 || j == 0) {
		                if(i == 0)
		                    dp[i][j] = j;
		                if(j == 0)
		                    dp[i][j] = i;
		            }
		            else {
		                if(str1.charAt(i-1) == str2.charAt(j-1)) {
		                    dp[i][j] = dp[i-1][j-1];
		                }
		                else {
		                    dp[i][j] = min(dp[i-1][j],dp[i-1][j-1],dp[i][j-1]) + 1;
		                }
		            }
		        }
		    }
		    
		   for(int i = 1;i<=n;i++) {
		       for(int j = 1;j<=m;j++) {
		           System.out.print(dp[i][j] + " ");
		       }
		       System.out.println();
		   }
		    
		    System.out.println(dp[n][m]);
		}
     } 
     
     public static int min(int a,int b,int c) {
	    if(a<b && a<c) {
	        return a;
	    }
	    else if(b<c) {
	        return b;
	    }
	    return c;
	}
}