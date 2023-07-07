import java.util.*;
public class ReverseString {
    // public static String reverseString(String str){
    //     Stack<Character> s = new Stack<>();
    //     int idx =0;
    //     while(idx<str.length()){
    //         s.push(str.charAt(idx));
    //         idx++;
    //     }
    //     StringBuilder result = new StringBuilder("");
    //    while(!s.empty()){
    //     char curr = s.pop();
    //     result.append(curr);
    //    }
    //    return result.toString();
    // }

    public static void reverseString(char[] s){
        Stack<Character> sc = new Stack<>();
        int i=0;
        while(i<s.length){
            sc.push(s[i]);
            i++;
        }
        while(!sc.empty()){
            s[i]=sc.pop();
        }

    }
    public static void main(String[] args) {
        // String str = "abc";
        // String res = reverseString(str);
        // System.out.println(res);




        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        
       
    }
}
