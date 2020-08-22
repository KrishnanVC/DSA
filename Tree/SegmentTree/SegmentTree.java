import java.util.*;

public class SegmentTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        int k = nextPower(n);
        int[] segment = new int[k];
        construct(arr, segment, 0, n-1, 0);
        System.out.println(Arrays.toString(segment));
        sc.close();
    }

    public static void construct(int[] arr, int[] segment, int start, int end,int pos) {
        if(start == end) {
            segment[pos] = arr[start];
        }
        else {
            int mid = (start + end) / 2;
            construct(arr, segment, start, mid, pos*2 + 1);
            construct(arr, segment, mid+1, end, pos*2 + 2);
            segment[pos] = segment[pos*2 + 1] + segment[pos*2 + 2];
        }
    }

    public static int nextPower(int n) {
        int a = 1;
        while(a < n) {
            a = a << 1;
        }
        return 2 * a -1;
    }
}