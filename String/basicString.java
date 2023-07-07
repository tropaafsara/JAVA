import java.util.*;

public class basicString {
    public static void printLetters(String str) {
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(i)+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // String str = "abcd";
        // Scanner sc = new Scanner(System.in);
        // //strings are immutable
        // String name = sc.nextLine();
        // System.out.println(name);

        // String str2= "Tony Stark";
        // System.out.println(str2.length());

        //concatenation
        String firstName = "alu";
        String lastName = "porota";
        String fullName = firstName+lastName;
        // System.out.println(fullName);
        // charAt method
        // System.out.println(fullName.charAt(1));
        printLetters(fullName);
        

    }
}
