public class practice {
    public static void spiralMatrix(int matrix[][]){
        int StartRow = 0;
        int StartCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;
        while(StartRow<=endRow && StartCol<=endCol){
            //top
            for(int i=StartCol; i<=endCol;i++){
                System.out.print(matrix[StartRow][i]+" ");
            }
            //right
            for(int j=StartRow+1;j<=endRow;j++){
                System.out.print(matrix[j][endCol]+" ");
            }
            //bottom
            for(int i=endCol-1;i>=StartCol;i--){
                if(StartRow==endRow){
                    break;
                }
                System.out.print(matrix[endRow][i]+" ");
            }
            //left
            for(int j=endRow-1;j>=StartRow+1;j--){
                if(StartCol==endCol){
                    break;
                }
                System.out.print(matrix[j][StartCol]+" ");
            }
            StartRow ++;
        endRow --;
        StartCol ++;
        endCol --;
        }
        
        System.out.println();
    }
    public static void diagonalSum(int matrix[][]){
        int sum=0;
        for(int i=0;i<matrix.length;i++){
            sum+= matrix[i][i];
            if(i!=matrix.length-i-1)//overlapping condition
            sum+= matrix[i][matrix.length-i-1];
        }
        System.out.println(sum);
    }
    public static void staircaseSearch(int matrix[][], int key) {
        // for(int i=0;i<matrix.length;i++){
        //     for(int j=0;j<matrix[0].length;j++){
        //         if(key==matrix[i][j]){
        //             System.out.println("key found at index :"+i+j);
        //             break;
        //         }
                
        //     }
        // }


        int row=0;
        int col= matrix[0].length-1;
        while(row<matrix.length && col>=0){
            if(matrix[row][col]==key){
                System.out.println("key found at index :"+row+col);
            }
            if(key<matrix[row][col]){
                col--;
            }else{
                row++;
            }
            
        }
        
    }
    public static void main(String[] args) {
        int matrix[][]={{10,20,30,40},
                        {15,25,35,45},
                        {27,29,37,48},
                        {32,33,39,50}};
        // int matrix[][]={{1,2,3,4},
        //                 {5,6,7,8},
        //                 {9,10,11,12},
        //                 {13,14,15,16}};
        // spiralMatrix(matrix);
        // diagonalSum(matrix);
        staircaseSearch(matrix, 39);

    }
}
