import java.util.*;

public class LongestCommonSuper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt(); sc.nextLine();
	    while(t-- > 0) {
	        int n = sc.nextInt();
	        int m = sc.nextInt(); sc.nextLine();
	        int[][] dp = new int[n+1][m+1];
	        String str1 = sc.nextLine();
	        String str2 = sc.nextLine();
                  
            for (int i = 0; i <= n; i++) 
            { 
                for (int j = 0; j <= m; j++) 
                { 
                if (i == 0) 
                    dp[i][j] = j; 
                else if (j == 0) 
                    dp[i][j] = i; 
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) 
                        dp[i][j] = 1 + dp[i - 1][j - 1]; 
                else
                        dp[i][j] = 1 + Math.min(dp[i - 1][j],  
                                                dp[i][j - 1]); 
                } 
            } 
      
	        
           System.out.println(dp[n][m]);
        }
    }
}