import java.util.Stack;

public class Q2 {

    public static int checkRedundancy(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch==')'){
                char top = s.peek();
                s.pop();
                int flag =1;
                while(!s.isEmpty() && top!='('){
                    if(top=='+'||top=='-'||top=='*'||top=='/'){
                        flag =0;
                    }
                    top = s.peek();
                    s.pop();
                } 

                if(flag==1){
                    return 1;
                }

            }else{
                s.push(ch);
            }
        }
        return 0;
        
    }
    
    public static void main(String[] args) {
        String str = "((a+b))";
        System.out.println(checkRedundancy(str));
    }
}
