import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
public class practice {
    public static int solve(String str ){
        Stack<Character> s = new Stack<>();
        int sum = 0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch==')'){
                if(s.peek()=='('){
                    s.pop();
                    s.push('1');
                }else{
                    while(s.peek()!='('){
                        sum+=s.pop()-'0';
                    }
                    s.pop();
                    s.push((char)(2*sum+'0'));
                }

            }else{
                s.push(ch);
            }
        }
        int res = 0;
        while(!s.isEmpty()){
            res+=s.pop()-'0';
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(solve("(())"));


        

    }
}
