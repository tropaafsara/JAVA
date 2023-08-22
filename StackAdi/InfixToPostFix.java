import java.util.Stack;

public class InfixToPostFix {
    public static int prec(char c){
        if(c == '^') return 3;
        else if(c == '/' || c == '*') return 2;
        else if(c == '+' || c == '-') return 1;
        return -1;
    }
    public static String infixToPostfix(String str){
        String res = "";
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            Character ch = str.charAt(i);
            if(Character.isLetter(ch)){
                res+=ch;
            }else{
                if(ch=='('){
                    s.push(ch);
                }
                else if(ch==')'){
                    while(s.peek()=='('){
                        s.pop();
                    }
                    s.pop();
                }else{
                    while(!s.isEmpty() && prec(ch)<=prec(s.peek())){
                        res+=s.peek();
                        s.pop();
                    }
                    s.push(ch);
                }
            }

        }
        while(!s.empty()) {
            res += s.peek();
            s.pop();
        }
        return res;
    }
    public static void main(String[] args) {
        String str = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(str));
    }
}
