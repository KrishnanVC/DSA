public class KnightTour {

    static boolean done = false;
    
    public static void main(String[] args) {
        int[][] mat = new int[8][8];
        BT(mat,0,4,1);
    }

    public static void BT(int[][] mat, int i, int j, int count) {
        if(i>=0 && i<8 && j>=0 && j<8 && mat[i][j] == 0 && done != true) {
            mat[i][j] = count;
            //print(mat);
            //System.out.println();
            if(count == 64) {
                print(mat);
                done = true;
            }
            else{
                BT(mat,i-2,j-1,count+1);   
                BT(mat,i-2,j+1,count+1);   
                BT(mat,i-1,j-2,count+1);
                BT(mat,i-1,j+2,count+1);   
                BT(mat,i+1,j-2,count+1);   
                BT(mat,i+1,j+2,count+1);   
                BT(mat,i+2,j-1,count+1);   
                BT(mat,i+2,j+1,count+1);   
            }
            mat[i][j] = 0;  
        }
    }

    public static void print(int[][] mat) {
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                System.out.printf("%2d ",mat[i][j]);
            }
            System.out.println();
        }
    }
}