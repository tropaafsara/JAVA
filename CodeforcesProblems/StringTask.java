import java.util.Scanner;

public class StringTask {
    public static boolean isVowel(char ch){
        if(ch=='a'||ch=='i'||ch=='o'||ch=='u'||ch=='y'||ch=='e'){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();

        String s = s1.toLowerCase();
        char c = '.';

        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);

            if(!isVowel(ch)){//consonant
                sb.append(c);
                sb.append(ch);
            }            
        }
        

        System.out.println(sb);
    }
}
