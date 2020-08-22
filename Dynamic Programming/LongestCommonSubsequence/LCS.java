import java.util.*;

public class LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt(); sc.nextLine();
	    while(t-- > 0) {
	        int n = sc.nextInt();
	        int m = sc.nextInt(); sc.nextLine();
	        int[][] dp = new int[n+1][m+1];
	        String str1 = sc.nextLine();
	        String str2 = sc.nextLine();
	        
	        for(int i=1;i<=n;i++) {
	            for(int j=1;j<=m;j++) {
                    if(str1.charAt(i-1) == str2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                    else {
                        dp[i][j] = dp[i][j-1] > dp[i-1][j]? dp[i][j-1]: dp[i-1][j];
                    }
	            }
	        }
           System.out.println(dp[n][m]);
        }
    }
}