import java.util.Arrays;
import java.util.Comparator;

public class Google {
    public static int formbiggestNum(int[] digits){
        String[] s = new String[digits.length];
        for (int i = 0; i < digits.length; i++) {
            s[i] = Integer.toString(digits[i]);
        }
         
       String s1 = "";
       for(int i=0;i<s.length-2;i++){
        for(int j=i+1;j<s.length-1;j++){
             m1 = Math.max(s[i],s[j]);
            for(int k=j+1;k<s.length;k++){
                
            }
        }
       }
    }
    public static void main(String[] args) {
        int[] digits = {0,0,5,7};
        int res = formbiggestNum(digits);
        System.out.println(res);
    }
}
