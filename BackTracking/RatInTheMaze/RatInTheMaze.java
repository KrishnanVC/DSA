public class RatInTheMaze {
    
    public static ArrayList<String> printPath(int[][] m, int n) {
        ArrayList<String> list = new ArrayList<>();
        printBT(m,n,0,0,"",list);
        return list;
    }
    
    public static void printBT(int[][] m, int n, int i, int j,String path,ArrayList<String> list) {
        if(i>=0 && i<n && j>=0 && j<n && m[i][j] == 1) {
            m[i][j] = 0;
            if(i == n-1 && j == n-1) {
                list.add(path);
            }
            else {
                printBT(m,n,i+1,j,path+"D",list);
                printBT(m,n,i,j-1,path+"L",list);
                printBT(m,n,i,j+1,path+"R",list);
                printBT(m,n,i-1,j,path+"U",list);
            }
            m[i][j] = 1;
        }
    }
}