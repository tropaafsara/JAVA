import java.util.Scanner;
import java.util.Stack;

public class cc {
    public static int countSchrodingerSmileys(int a , String s){
        int count =0;
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                continue;
            }
            if(s.charAt(i)==':'){
                st.push(s.charAt(i));
                
                    if( i+2<s.length() && s.charAt(i+1)==')'){
                        st.push(s.charAt(i+1));

                        for(int k=i+2;k<s.length();k++){
                            if(s.charAt(k)==')'){
                                st.push(s.charAt(k));
                            }else if(s.charAt(k)==':'){
                                int idx = k;
                                i=k;
                                count++;
                                while(!st.isEmpty() ){
                                st.pop();
                                }
                            // st.push(s.charAt(k));                            
                            }
                            
                        }

                    }
                
            }
            
            
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n;i++){
            int a = sc.nextInt();
            
            String s = sc.next();
            int count = countSchrodingerSmileys(a, s);
            System.out.println(count);
        }
    }
}
