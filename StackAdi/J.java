import java.util.Stack;

public class J {
    public static boolean solve(String s, String t){
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for(int i =0; i<s.length();i++){
            char ch = s.charAt(i);
            if(!s1.isEmpty() && ch=='#'){
                s1.pop();
            }else{
                s1.push(ch);
            }
        }
        for(int i =0; i<t.length();i++){
            char ch = s.charAt(i);
            if(!s2.isEmpty() && ch=='#'){
                s2.pop();
            }else{
                s2.push(ch);
            }
        }
        return s1.equals(s2);
    }
    public static void main(String[] args) {
        String s ="a#c";
        String t ="b";
        System.out.println(solve(s, t));

    }
}
