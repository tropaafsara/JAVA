import java.util.Stack;

public class RemoveDuplicateLetters {
    //print duplicates
    public static void printDuplicates(String s){
        int[] a= new int[26];
        for(int i=0; i<s.length();i++){
            a[s.charAt(i)-'a']++;
        }
        for(int i=0; i<a.length;i++){
            char letter =(char) ('a'+i);
            if(a[i]>1){
                System.out.println(letter+" = "+a[i]);
            }
        }
    }


    //remove duplicates
    public static String removeDuplicateLetters(String s) {
        // frequency
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        Stack<Character> st = new Stack<>();
        boolean vis[] = new boolean[freq.length];
        for (int i = 0; i < s.length(); i++) {
        
            if (vis[s.charAt(i) - 'a']) {
                freq[s.charAt(i)-'a']--;
                continue;
            }
            while (!st.isEmpty() && st.peek() > s.charAt(i) && freq[st.peek() - 'a'] > 0) {
                vis[s.charAt(i) - 'a'] = false;
                st.pop();
                
            }
            vis[s.charAt(i) - 'a'] = true;
            st.push(s.charAt(i));
            freq[s.charAt(i)-'a']--;
            
        }
        StringBuilder sb = new StringBuilder(st.size());
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "bcabc";
        System.out.println(removeDuplicateLetters(str));
    }
}
