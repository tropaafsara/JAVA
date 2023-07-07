public class code {
    public static void main(String[] args) {
        int numbers[]={3,2,4};
        int target =6;
        
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;i<numbers.length-1;j++){
                if(numbers[i]+numbers[j]==target){
                    System.out.println(i+" "+j);
                }
            }
        
            

        }
    }
}
