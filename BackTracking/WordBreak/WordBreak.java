/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

public class WordBreak {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
		    int n = sc.nextInt(); sc.nextLine();
		    String[] words = sc.nextLine().split(" ");
		    HashSet<String> hash = new HashSet<>();
		    for(String word: words) {
		        hash.add(word);
		    }
		    String s = sc.nextLine();
		    String ans = "";
		    int len = s.length();
		    BT(s, ans, hash, 0, len);
		    System.out.println();
		}
	}
	
	public static void BT(String s, String ans, HashSet<String> hash, int start, int n) {
	    if(start == n) {
	        System.out.print("("+ans.strip()+")");
	    }
	    else {
	        for(int i = 0;i < n - start + 1 ; i++) {
	           String temp = s.substring(start,start + i);
	           if(hash.contains(temp)) {
	               BT(s, ans+" "+temp, hash, start+i, n);
	           }
	        }
	    }
	}
}