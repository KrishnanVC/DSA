import java.util.*;
import java.lang.*;
import java.io.*;

class FloydWarshall {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); sc.nextLine();
		while(t-- > 0) {
		    int v = sc.nextInt();
		    int[][] A = new int[v][v];
		    for(int i=0;i<v;i++) {
		        for(int j=0;j<v;j++) {
		            A[i][j] = sc.nextInt();
		        }
		    }
		    for(int k=0; k<v; k++) {
		        for(int i=0;i<v;i++) {
		            if(i == v) {
		                continue;
		            }
		            for(int j = 0;j < v;j++) {
		                if(i==j || j==k){
		                    continue;
		                }
		                A[i][j] = min(A[i][j], (A[i][k] + A[k][j]));
		            }
		        }
		    }
		    
		    for(int i=0;i<v;i++) {
		        for(int j=0;j<v;j++) {
		            if(A[i][j] == 1e7){
		                System.out.print("INF ");
		            }
		            else {
		                System.out.print(A[i][j] + " ");
		            }
		        }
		        System.out.println();
		    }
		}
		sc.close();
	}
	
	static int min(int a,int b) {
	    return a<b?a:b;
	}
}