import java.util.*;
public class practriceTwo {
    // public static void main(String[] args) {
    //     int matrix[][]={{4,7,8},
    //                     {8,8,7}};
    //     int count=0;
    //     for(int i=0;i<matrix.length;i++){
    //         for(int j=0;j<matrix[0].length;j++){
    //             if(7==matrix[i][j]){
    //                 count++;
    //             }
    //         }
    //     }
    //     System.out.println(count);
    // }




    // public static void main(String[] args) {
    //     int matrix[][]={{1,4,9},{11,4,3},{2,2,3}};
    //     int sum=0;
    
    //         for(int j=0;j<matrix[0].length;j++){
                
    //                 sum+= matrix[1][j];
                
    //         }
        
    //     System.out.println(sum);
    // }



   



    public static void printMatrix(int matrix[][]) {
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int matrix[][]={{1,2,3},{4,5,6}};
        int row=2, col=3;
        //printing original matrix
        System.out.println("The original matrix is");
        printMatrix(matrix);
        //transpose the matrix
        int transpose[][]= new int [col][row];
        for(int i=0;i<row;i++){
            for(int j=0; j<col; j++){
                transpose[j][i]= matrix[i][j];
            }
            System.out.println();
        }
        //print transpose matrix
        System.out.print("The transpose matrix is");
        printMatrix(transpose);
    }
}
