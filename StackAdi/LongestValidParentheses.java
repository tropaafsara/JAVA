import java.util.Stack;

public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        Stack<Character> st = new Stack<>();
        int count =0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
             if(ch==')' && st.peek()=='('){
                count+=2;
                st.pop();
                continue;
            }
            st.push(ch);
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "()(()))))";
        System.out.println(longestValidParentheses(s));

    }
}
