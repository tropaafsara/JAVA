import java.util.Stack;

public class EasyLeetCode {
    // 844. Backspace String Compare
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        String r1 = "";
        String r2 = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!st1.isEmpty() && ch == '#') {
                st1.pop();
            } else if (st1.isEmpty() && ch == '#') {
                continue;
            } else {
                st1.push(ch);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!st2.isEmpty() && ch == '#') {
                st2.pop();
            } else if (st2.isEmpty() && ch == '#') {
                continue;
            } else {
                st2.push(ch);
            }
        }

        // while (!st1.isEmpty()) {
        // r1 += st1.pop();
        // }
        // while (!st2.isEmpty()) {
        // r2 += st2.pop();
        // }

        // if(r1.equals(r2)){
        // return true;
        // }else{
        // return false;
        // }

        return st1.equals(st2);
    }

    public static String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (st.isEmpty() && ch == '(') {
                st.push(ch);
            } else if (!st.isEmpty() && ch == '(') {
                st.push(ch);
                res += ch;
            } else if (st.size() > 1 && ch == ')') {
                st.pop();
                res += ch;
            } else if (st.size() == 1 && ch == ')') {
                st.pop();
            }
        }
        return res;
    }

    // 1475. Final Prices With a Special Discount in a Shop (Next Smaller Right)
    public static int[] finalPrices(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int n = arr.length;
        int[] v = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (s.isEmpty()) {
                v[i] = arr[i] - 0;
            } else if (!s.isEmpty() && s.peek() < arr[i]) {
                v[i] = arr[i] - s.peek();
            } else if (!s.isEmpty() && s.peek() >= arr[i]) {
                while (!s.isEmpty() && s.peek() >= arr[i]) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    v[i] = arr[i] - 0;
                } else {
                    v[i] = arr[i] - s.peek();
                }
            }
            s.push(arr[i]);
        }
        return v;
    }
    //682. Baseball Game

    public static int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("C")) {
                s.pop();
            } else if (operations[i].equals("D")) {
                s.push(s.peek() * 2);
            } else if (s.size() >= 2 && operations[i].equals("+")) {
                int x = s.pop();
                int y = s.pop();
                int z = x + y;
                s.push(y);
                s.push(x);
                s.push(z);
            } else {
                s.push(Integer.parseInt(operations[i]));
            }

        }
        int res = 0;
        while (!s.isEmpty()) {
            res += s.pop();
        }
        return res;
    }

    // 1047. Remove All Adjacent Duplicates In String
    public static String removeDuplicates(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=str.length()-1;i>=0;i--){
            char ch = str.charAt(i);
            if(!s.isEmpty() && s.peek().equals(ch)){
                s.pop();
            }else{
                s.push(str.charAt(i));
            }
        }
        String res="";
        while(!s.isEmpty()){
            res+=s.pop();
        }
        return res;

    }
    public static void main(String[] args) {
        // 844
        // String s1 = "a#c";
        // String s2 = "b";
        // System.out.println(backspaceCompare(s1, s2));

        // String s = "(()())(())";
        // System.out.println(removeOuterParentheses(s));

        // int[] prices = {8,4,6,2,3};
        // int[] v = finalPrices(prices);
        // for(int i=0;i<v.length;i++){
        // System.out.print(v[i]+" ");
        // }

        // String[] operations = { "5","-2","4","C","D","9","+","+" };
        // System.out.println(calPoints(operations));

        String s ="abbaca";
        System.out.println(removeDuplicates(s));

    }
}
