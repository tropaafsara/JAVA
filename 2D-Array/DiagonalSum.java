public class DiagonalSum {
    public static int DiagonalSum(int matrix[][]){
        int sum=0;
        // for(int i=0;i<matrix.length;i++){ //O(n^2)
        //     for(int j=0;j<matrix[0].length;j++){
        //         if(i==j){
        //             sum+=matrix[i][j];
        //         }
        //         else if(i+j == matrix.length-1){
        //             sum+= matrix[i][j];
        //         }
        //     }
        // }

            //optimized code
        for(int i=0;i<matrix.length;i++){ //O(n)
            //pd
            sum+= matrix[i][i];
            //sd
            if(i !=matrix.length-i-1) //if i is not equal to j then we'll calculate secondary element
            sum+= matrix[i][matrix.length-i-1];
        }
        return sum;
    }
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3,4},
                          {5,6,7,8},
                          {9,10,11,12},
                          {13,14,15,16}};
        System.out.println(DiagonalSum(matrix));
    }
}
