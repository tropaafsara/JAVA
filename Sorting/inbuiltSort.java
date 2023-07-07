import java.util.Arrays;
import java.util.Collections;
public class inbuiltSort {
    public static void printArray(Integer n[]) {
        for(int i=0;i<n.length;i++){
            System.out.print(n[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // int numbers[]={4,3,2,0,1};
        Integer numbers[]={4,3,2,0,1};
        // Arrays.sort(numbers);
        // Arrays.sort(numbers,0,3);//toIndex : index+1
        // Arrays.sort(numbers,0,3,Collections.reverseOrder());
        Arrays.sort(numbers,Collections.reverseOrder());
        printArray(numbers);
    }
}
