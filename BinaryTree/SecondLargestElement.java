import java.util.Arrays;

public class SecondLargestElement {
    public static void main(String[] args) {
        int array[] = {3,4,6,8,2,10};
        Arrays.sort(array);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<array.length-1;i++){
            if(array[i]>max){
                max = array[i];
            }
        }
        System.out.println(max);
        
    }
}
