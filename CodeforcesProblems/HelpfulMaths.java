import java.util.*;

public class HelpfulMaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(); //"1+8+9"
        
        String[] numbers = s.split("\\+");//['1','8','9']
        int[] extractedIntegers = new int[numbers.length];
        for(int i=0;i<numbers.length;i++){
            extractedIntegers[i] = Integer.parseInt(numbers[i]); //[1,8,9]
            
        }
        Arrays.sort(extractedIntegers);
        for(int i=0;i<extractedIntegers.length;i++){
            System.out.print(extractedIntegers[i]);
            if(i<extractedIntegers.length-1){
                System.out.print("+");
            }
        }
        System.out.println();
        
    }
}
