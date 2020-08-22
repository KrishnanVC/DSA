import java.util.*;

public class PathHurdle {

    static int[][] ans;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat = new int[n][m];
        ans = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        BT(mat,0,0,1,7,n,m, 1);
        print(ans);
        sc.close();
    }

    public static void BT(int[][] mat, int i, int j, int destI, int destJ, int n, int m, int count) {
        if(i>=0 && i<n && j>=0 && j<m && mat[i][j] != 0 && mat[i][j] > 0) {
            mat[i][j] = -count;
            if(i == destI && j == destJ && count>max) {
                copy(mat);
                max = count;
            }
            else {
                BT(mat, i+1, j, destI, destJ, n, m, count+1);
                BT(mat, i-1, j, destI, destJ, n, m, count+1);
                BT(mat, i, j+1, destI, destJ, n, m, count+1);
                BT(mat, i, j-1, destI, destJ, n, m, count+1);
            }
            mat[i][j] = 1;
        }
    }

    public static void print(int[][] mat) {
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                System.out.printf("%3d ",mat[i][j]);
            }
            System.out.println();
        }
    }

    public static void copy(int[][] mat) {
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                ans[i][j] = mat[i][j];
            }
        }
    }
}