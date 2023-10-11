import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CP {
    
    //
    public static String maximumOddBinaryNumber(String s) {
        int ones = countOnes(s);
        int zeros = countZeros(s);

        if (ones == 0) {
            return "0";
        }

        String result = buildResult(ones, zeros);

        return result;
    }

    private static int countOnes(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }

    private static int countZeros(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                count++;
            }
        }
        return count;
    }

    private static String buildResult(int ones, int zeros) {
        String result = "1"; // place one '1' at the end
        ones--;

        result = "0".repeat(zeros) + result; // place all '0's
        result = "1".repeat(ones) + result; // place the remaining '1's

        return result;
    }
    //
    public static String solve(String s){
        if(s.length()==0){
            return "";
        }
        int zero=0,one=0;
        for(int i=s.length()-2;i>=0;i--){
            char ch = s.charAt(i);
            if(ch=='1' && s.charAt(s.length()-1)=='0'){
                s = swap(s, i, s.length()-1);
                continue;
            }else if(ch=='1'){
                one = i;
            }
            else if(ch=='0'){
                zero = i;
            }
        }
        if(zero<one){
            s = swap(s,one, zero);
        }
        return s;
    }
    public static String solve2(String s){
        if(s.length()==0){
            return "";
        }
        int ptr1=-1,ptr2=-1;
        for(int i=0;i<s.length()-2/2;i++){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(s.length()-1-i);
            // if(ch=='1' && s.charAt(s.length()-1)=='0'){
            //     s = swap(s, i, s.length()-1);
            //     continue;
            // }else 
            
            if(ch1=='0'){
                ptr1 = i;
            }else if(ch2=='1'){
                ptr2 = i;
            }
            if(ptr1!=-1 && ptr2!=-1){
                s = swap(s, ptr1, ptr2);
            }
        }
        return s;
    }
    //swap characters in string
    public static String swap(String s, int idx1, int idx2){
        char[] charArr= s.toCharArray();
        char temp = charArr[idx1];
        charArr[idx1] = charArr[idx2];
        charArr[idx2] = temp;
        return new String(charArr);
    }
    public static void main(String[] args) {
        System.out.println(solve("01"));
    }
}
