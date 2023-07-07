import java.util.Stack;

public class Practice10 {
    public static boolean checkPalindrome(String s){
        int i=0;
        int j = s.length()-1;
        while(i<j){
             
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{  
                return false;
            }
        }
        return true;
    }
    //print duplicates
    public static void printDuplicates(String s){
        int[] a= new int[26];
        for(int i=0; i<s.length();i++){
            a[s.charAt(i)-'a']++;
        }
        for(int i=0; i<a.length;i++){
            char letter =(char) ('a'+i);
            if(a[i]>1){
                System.out.println(letter+" = "+a[i]);
            }
        }
    }
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        // System.out.println(checkPalindrome(s));
        printDuplicates(s);
    }
}
