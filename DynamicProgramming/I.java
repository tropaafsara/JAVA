import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
public class I {
    public static int decodeAtIndex(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(! s.isEmpty() && ch==')' && s.peek()=='('){
                s.pop();
                continue;
            }
            s.push(ch);
        }
        return s.size();
    }
    public static void main(String[] args) {
        String s = "()))";
        System.out.println(decodeAtIndex(s));
        
    }
}
