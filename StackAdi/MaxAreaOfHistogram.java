import java.util.Stack;

public class MaxAreaOfHistogram {
    // nearest smaller element to left
    public static int[] nearestSmallerElementLeft(int[] arr, int n) {// 0(n)
        Stack<Integer> s = new Stack<>();
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.isEmpty()) {
                v[i] = -1;
            } else if (!s.isEmpty() && arr[s.peek()] < arr[i]) {
                v[i] = s.peek();
            } else if (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    v[i] = -1;
                } else {
                    v[i] = s.peek();
                }
            }
            s.push(i);
        }
        return v;
    }

    // nearest smaller Element right
    public static int[] nearestSmallerElementRight(int[] arr, int n) {// 0(n)
        Stack<Integer> s = new Stack<>();
        int[] v = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (s.isEmpty()) {
                v[i] = n;
            } else if (!s.isEmpty() && arr[s.peek()] < arr[i]) {
                v[i] = s.peek();
            } else if (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    v[i] = n;
                } else {
                    v[i] = s.peek();
                }
            }
            s.push(i);
        }
        return v;
    }

    public static int maxAreaOfHistogram(int[] stocks, int n) {// 0(n)
        int[] nsr = nearestSmallerElementRight(stocks, n);
        int[] nsl = nearestSmallerElementLeft(stocks, n);

        System.out.print("nsl = ");
        for (int i = 0; i < nsl.length; i++) {
        System.out.print(nsl[i] + " ");
        }
        System.out.println();
        System.out.print("nsr = ");
        for (int i = 0; i < nsr.length; i++) {
        System.out.print(nsr[i] + " ");
        }
        System.out.println();

        int[] width = new int[n];
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            width[i] = (nsr[i] - nsl[i] - 1) * stocks[i];
            maxArea = Math.max(width[i], maxArea);
        }
        return maxArea;
    }

    // max area rectangle in binary matrix
    public static int maxAreaOfBinaryMatrix(int M[][], int m, int n) {
        int[] v = new int[m];
        for (int i = 0; i < m; i++) {//for one value
            v[i] = M[0][i];
        }
        int max = maxAreaOfHistogram(v, m);
      
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j] == 0) {
                    v[j] = 0;
                } else {
                    v[j] = v[j] + M[i][j];
                }
            }

            max = Math.max(max, maxAreaOfHistogram(v, m));

        }
        return max;
    }
    //leetcode
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] M = new int[row][col];
        //convert character into integer
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                M[i][j] = matrix[i][j]-'0';
            }
        }
        return maxAreaOfBinaryMatrix(M,col,row);
    }

    public static void main(String[] args) {
        // max area of histogram
        int[] stocks = {4,1,2,4,6,2,5};
        // int[] stocks = {6,2,5,4,5,1,6};
        // int[] stocks = {2,1,5,6,2,3};
        int v = maxAreaOfHistogram(stocks, stocks.length);
        System.out.println(v);

        // int n = 4;// row
        // int m = 5;// col
        // int M[][] = { { 1, 0, 1, 0, 0 },
        //         { 1, 0, 1, 1, 1 },
        //         { 1, 1, 1, 1, 1 },
        //         { 1, 0, 0, 1, 0 }
        // };
        // int M[][] = {{0, 1, 1, 0},
        // {1, 1, 1, 1},
        // {1, 1, 1, 1},
        // {1, 1, 0, 0}};

        // int res = maxAreaOfBinaryMatrix(M, m, n);
        // System.out.println(res);
    }
}
