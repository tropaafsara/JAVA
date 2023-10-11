import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DSASheet {
    //check redundancy
    public static int checkRedundancy(String str) {
        Stack<Character> s = new Stack<>();
        
        for(int i=0;i<str.length();i++){
            int flag = 0;
            char ch = str.charAt(i);
            if(ch==')'){
                if(s.peek()=='('){
                    return 1;
                }else{
                    while(s.peek()!='('){
                        if(s.peek()=='+'|| s.peek() =='-' || s.peek()=='*'||s.peek()=='/'){
                            flag=1;
                        }
                        s.pop();
                    }
                    s.pop();
                    if(flag==0){
                        return 1;
                    }
                }
            }else{
                s.push(ch);
            }
            
        }
        return 0;
        
    }
    //check duplicate parenthesis
    public static int checkDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        
        for(int i=0;i<str.length();i++){
            int flag = 0;
            char ch = str.charAt(i);
            if(ch==')'){
                if(s.peek()=='('){
                    return 1;
                }else{
                    while(s.peek()!='('){
                        s.pop();
                    }
                    s.pop();
                }
            }else{
                s.push(ch);
            }
            
        }
        return 0;
        
    }

    //score of parenthesis
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
    // 1249. Minimum Remove to Make Valid Parentheses
    public static String minRemove(String str){
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(Character.isAlphabetic(ch)){
                continue;
            }
            if(ch=='('){
                s.push(i);
            }else{//ch==')'
                if(!s.isEmpty() && str.charAt(s.peek())=='('){
                    s.pop();
                }else{//stack empty 
                    s.push(i);
                }
            } 
        }

        //remove character from string and print
        //approach-1
        StringBuilder sb = new StringBuilder();
        for(int i=str.length()-1;i>=0;i--){
            if(!s.isEmpty() && s.peek()==i){
                s.pop();
                continue;
            }
            sb.append(str.charAt(i));
        }
        sb.reverse();

        //approach-2
        // HashSet<Integer> hs = new HashSet<>(s);
        // StringBuilder sb = new StringBuilder();
        // for(int i=0;i<str.length();i++){
        //     if(!hs.contains(i)){
        //         sb.append(str.charAt(i));
        //     }
        // }
        return sb.toString();
    }
    //1190. Reverse Substrings Between Each Pair of Parentheses
    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        Queue<Character> q = new LinkedList<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch==')'){
                while(!s.isEmpty() && s.peek()!='('){
                    q.add(s.pop());
                }
                s.pop();
                while(!q.isEmpty()){
                    s.push(q.remove());
                }
            }else{
                s.push(ch);
            }
        }
        //print string from stack
        StringBuilder sb = new StringBuilder();
        
        //approach-1
        // while(!s.isEmpty()){
        //     sb.append(s.pop());
        // }
        // sb.reverse();
        // return sb.toString();

        //approach-2
        char[] ans = new char[s.size()];
        for(int i=s.size()-1;i>=0;i--){
            ans[i] = s.pop();
        }
        return new String(ans);
    }
    public static void main(String[] args) {
        System.out.println(reverseString("(u(love)i)"));
    }
}
