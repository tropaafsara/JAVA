import java.util.*;

public class Medium {
    //1328. Break a Palindrome
    public static String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if(n==1){
            return "";
        }
        /* 1st approcach */

        // char[] ch = palindrome.toCharArray();
        // for(int i=0;i<ch.length/2;i++){
        //     if(ch[i]!='a'){
        //         ch[i] = 'a';
        //         return new String(ch);
        //     }
        // }
        // ch[n-1]='b';
        // return new String(ch); 

        /* 2nd approach */

        StringBuilder sb = new StringBuilder(palindrome);
        for(int i=0;i<n/2;i++){
            if(palindrome.charAt(i)!='a'){
                sb.setCharAt(i, 'a');
                return sb.toString();
            }
        }
        sb.setCharAt(n-1, 'b');
        return sb.toString();
    }
    //179. Largest Number
    public static String largestNumber(int[] nums) {//nums = [3,30,34,5,9]
        String[] str = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            str[i] = String.valueOf(nums[i]);//str = ['3','30','34','5','9']
        }

        // Comparator to decide which string should come first in concatenation
        // Comparator<String> s = new Comparator<String>() {
        //     public int compare(String s1, String s2){
        //         return (s2+s1).compareTo(s1+s2);//descending order
        //     }
        // };
        // Arrays.sort(str, s);//custom comparison

        Arrays.sort(str, (a,b) -> (b + a).compareTo(a + b));//sorts based on 

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length;i++){
            sb.append(str[i]);
        }
        if(sb.charAt(0)=='0'){
            return "0";
        }
        return sb.toString();

    }
    //1647. Minimum Deletions to Make Character Frequencies Unique
    public static int minDeletions(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i), 0)+1);
        }
        int noOfDeletion = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int freq : hm.values()) {// hm.values() -> iterates over the values of the HashMap. 
            while(freq>0 && set.contains(freq)){
                freq--;
                noOfDeletion++;
            }
            set.add(freq);
        }
        return noOfDeletion;
    }
    //443. String Compression
    public static int compress(char[] chars) {
        int k = 0;
        int i = 0;
        while(i<chars.length){
            int j = i;
            while(j<chars.length && chars[j]==chars[i]){
                j++;
            }
            //this loop will break when two chars are not same or until we reach end of chars

            chars[k++] = chars[i];
            if(j-i>1){
                String count = j-i+"";
                for (char c : count.toCharArray()) {//if count = 10, c = '1','0';
                    chars[k++] = c;
                }
            }

            i=j;

        }
        return k;
    }
    //12. Integer to Roman
    public static String intToRoman(int num) {
        int values[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String romanNumbers[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        int i =0;
        while(num>0){
            if(num>=values[i]){
                sb.append(romanNumbers[i]);
                num-=values[i];
            }else{
                i++;
            }
        }
        return sb.toString();
    }
    //227. Basic Calculator II
    public static int calculate(String str) {
        Stack<Integer> s = new Stack<>();
        char operation = '+';
        int num = 0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(Character.isDigit(ch)){
                num = num*10+ch-'0';
            }else if(!Character.isDigit(ch) && ch!=' ' || i==str.length()-1){
                if(operation=='+'){
                    s.push(num);
                }
                else if(operation=='-'){
                    s.push(-num);
                }
                else if(operation=='*'){
                    s.push(s.pop()*num);
                }
                else if(operation=='/'){
                    s.push(s.pop()/num);
                }
                num=0;
                operation=ch;
            }
        }
        int ans = 0;
        while(!s.isEmpty()){
            ans+=s.pop();
        }
        return ans;
    }

    //680. Valid Palindrome II
    public static boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
    public static boolean valid(String s){
        int low=0;
        int high = s.length()-1;
        int k=0;
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(low)==s.charAt(high)){
                low++;
                high--;
            }else{
                return isPalindrome(s, low+1, high) || isPalindrome(s, low, high-1);
            }
        }
        return true;
    }
    //224. Basic Calculator
    public static int calculate2(String str) {
        Stack<Character> s = new Stack<>();
        char operator = '+';
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch==' '){
                continue;
            }
            if(ch=='('){
                s.push(ch);
            }
            if(ch==')'){
                int ans = 0;
                while(!s.isEmpty() && s.peek()!='('){
                    int num = s.pop()-'0';
                    ans+=num;
                }
                s.pop();
                s.push((char)(ans+' '));
            }
            if(Character.isDigit(ch)){
                char c = ch;
            }else if(!Character.isDigit(ch)){
                if(operator=='+'){
                    s.push(c);
                }
                else if(operator=='-'){
                    s.push((char)('-'+c));
                }
                c = '0';
                operator=ch;
            }
        }
        int ans = 0;
        while(!s.isEmpty()){
            char ch = s.pop();
            int num = ch-'0';
            ans+=num;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        String s = "2 - 1 + 2 ";
        System.out.println(calculate2(s));
    }
}
