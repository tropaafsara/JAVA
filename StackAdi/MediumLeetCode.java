import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MediumLeetCode {
    // Minimum Add to Make Parentheses Valid
    public static int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!st.isEmpty() && ch == ')' && st.peek() == '(') {
                st.pop();
                continue;
            }
            st.push(ch);

        }
        return st.size();
    }

    // Minimum Remove to Make Valid Parentheses
    public static String minRemoveToMakeValid(String str) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isAlphabetic(ch)) {
                continue;
            }
            if (ch == '(') {
                s.push(i);
            } else {
                if (!s.isEmpty() && str.charAt(s.peek()) == '(') {
                    s.pop();
                } else {
                    s.push(i);// stack empty and ch == )
                }
            }
        }
        StringBuilder res = new StringBuilder();
        HashSet<Integer> set = new HashSet<>(s);
        for (int i = 0; i < str.length(); i++) {
            if (!set.contains(i)) {
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }

    // 2390. Removing Stars From a String
    public static String removeStars(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!s.isEmpty() && ch == '*') {
                s.pop();
            } else {
                s.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        sb.reverse();
        return sb.toString();
    }

    // 1700. Number of Students Unable to Eat Lunch
    public static int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            s.push(sandwiches[i]);
        }
        for (int i = 0; i < students.length; i++) {
            q.add(students[i]);
        }
        int count = 0;
        // The poll() method of Queue Interface returns and removes the element at the
        // front end of the container
        while (!s.isEmpty()) {
            if (q.peek() == s.peek()) {

                q.poll();
                s.pop();

            } else {
                // rear == front && all will be shifted backwards
                int top = q.poll();
                q.add(top);
                count++;
            }
            if (count == q.size()) {
                return count;
            }
        }

        return 0;
    }

    // 2375. Construct Smallest Number From DI String
    public static String smallestNumber(String pattern) {
        Stack<Integer> s = new Stack<>();
        Stack<Integer> t = new Stack<>();
        String res = "";
        for (int i = 9; i >= 1; i--) {
            s.push(i);
        }
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (ch != 'D') {
                res += s.pop();
                while (t.size() > 0) {
                    res += t.pop();
                }
            } else {
                t.push(s.pop());
            }

        }
        t.push(s.pop());
        while (!t.isEmpty()) {
            res += t.pop();
        }

        return res;
    }

    // 1963. Minimum Number of Swaps to Make the String Balanced
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static int minSwaps(String str) {
        int count = 0;
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!s.isEmpty() && s.peek() == '[' && ch == ']') {
                s.pop();
                continue;
            }
            s.push(ch);
        }
        // while(!s.isEmpty()){
        // s.pop();
        // count++;
        // }
        // return count/2;
        // return s.size()/2;
        return (s.size() / 2 + 1) / 2;
    }

    public static String reverseParentheses(String str) {
        Stack<Character> s = new Stack<>();
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!s.isEmpty() && ch == ')') {
                while (s.peek() != '(') {
                    q.add(s.pop());
                }
                s.pop();
                while (!q.isEmpty()) {
                    s.push(q.poll());
                }
            } else {
                s.push(ch);
            }
        }
        char[] ans = new char[s.size()];
        int i = ans.length - 1;
        while (i >= 0) {
            ans[i] = s.pop();
            i--;
        }
        return new String(ans);
    }
    // 856. Score of Parentheses

    public static int scoreOfParentheses(String str) {
        Stack<Integer> s = new Stack<>();
        int res = 0;
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!s.isEmpty() && ch == ')' && s.peek() == -1) {// ()
                s.pop();
                // res=1;
                s.push(1);
                // s.push(res);
            } else if (!s.isEmpty() && ch == ')' && s.peek() != -1) {
                // 2 cases
                res = s.pop();
                // (1)=1*2
                if (s.peek() == -1) {
                    s.pop();
                    res *= 2;
                    s.push(res);
                } else {// (12)=1+2=3*2=6
                    res = 0;
                    while (s.peek() != -1) {
                        res += s.pop();
                    }
                    s.push(res);
                    // s.pop();
                }
            } else {
                s.push(-1);
            }

        }
        while (!s.isEmpty()) {
            ans += s.pop();
        }
        return ans;
    }

    public static int scoreOfParentheses1(String str) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                s.push(-1);
            } else {
                if (s.peek() == -1) {
                    s.pop();
                    s.push(1);
                } else {
                    int val = 0;
                    while (s.peek() != -1) {
                        val += s.pop();
                    }
                    s.pop();
                    s.push(2 * val);
                }
            }
        }
        //for "()()"
        int val = 0;
        while (s.size()>0) {
            val += s.pop();
        }
        return val;
    }

    public static void main(String[] args) {
        // String s = "()))((";
        // System.out.println(minAddToMakeValid(s));

        // String s = "lee(t(c)o)de)";
        // System.out.println(minRemoveToMakeValid(s));

        // String s = "leet**cod*e";
        // System.out.println(removeStars(s));

        // String s = "(())";
        // System.out.println(scoreOfParentheses(s));

        // int[] students = { 1, 1, 1, 0, 0, 1 };
        // int[] sandwiches = { 1, 0, 0, 0, 1, 1 };
        // System.out.println(countStudents(students, sandwiches));

        // String pattern = "IIIDIDDD";
        // System.out.println(smallestNumber(pattern));

        // String s = "][][";
        // String s = "][][][";
        // String s = "]]][[[";
        // System.out.println(minSwaps(s));

        // String s = "(ed(et(oc))el)";
        // System.out.println(reverseParentheses(s));

        // String s = "(()(()))";
        String s = "(())";
        System.out.println(scoreOfParentheses(s));
    }
}
