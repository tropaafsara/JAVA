import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class QueueReversal {
    public static int findUnsortedSubarray(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while(low+1<nums.length && nums[low] <=nums[low+1]){
            low++;
        }
        while(high-1>=0 && nums[high] >=nums[high-1]){
            high--;
        }
        if(low==nums.length-1){
            return 0;
        }
        for(int i=low;i<=high;i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        while(low-1>=0 && nums[low-1]>min){
            low--;
        }
        while(high+1<=nums.length-1 && max>nums[high+1]){
            high++;
        }
        return high-low+1;
    }
    //678. Valid Parenthesis String
    public static boolean checkValidString(String str) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='('){
                open.push(i);
            }
            else if(ch=='*'){
                star.push(i);
            }
            else if(ch==')'){
                if(!open.isEmpty()){
                    open.pop();
                }
                else if(!star.isEmpty()){
                    star.pop();
                }else{
                    return false;
                }
            }
        }
        while(!open.isEmpty()){
            if(star.isEmpty()){
                return false;
            }else if(open.peek()<star.peek()){
                open.pop();
                star.pop();
            }else{
                return false;
            }
        }
        return true;
    }
    //456. 132 Pattern
    public static boolean find132pattern(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int TE = Integer.MIN_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<TE){
                return true;
            }
            while(!s.isEmpty() && s.peek()<nums[i]){
                TE = s.pop();
            }
            s.push(nums[i]);
        }
        return false;
    }
    //402. Remove K Digits
    public static String removeKdigits(String num, int k) {
        Stack<Character> s = new Stack<>();
        if(k>=num.length()){
            return "0";
        }
        for(int i=0;i<num.length();i++){
            char ch = num.charAt(i);
            while(!s.isEmpty()&& k>0 && s.peek()>ch ){
                s.pop();
                k--;
            }
            s.push(ch);
        }
        //if k is remaining , remove biggest elements that are in top of the stack
        while(!s.isEmpty()&& k>0){
            s.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        sb.reverse(); 
        
        while(sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0); //while there is 0 int starting of string remove it
        
        return sb.toString();
      
    }
    //150. Evaluate Reverse Polish Notation
    public static int cal(int a, int b, char c){
        if(c == '+'){
            return a+b;
        }
        else if(c == '-'){
            return a-b;
        }
        else if(c == '*'){
            return a*b;
        }else{
            return a/b;
        }
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (String str : tokens) {
            if(str.equals("+")|| str.equals("-")|| str.equals("*")||str.equals("/")){
                int y = s.pop();
                int x = s.pop();
                int res = cal(x, y, str.charAt(0));
                s.push(res);
            }else{
                s.push(Integer.parseInt(str));//convert string to int
            }
        }
        return s.pop();
    }
    //2216. Minimum Deletions to Make Array Beautiful
    public static int minDeletion(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(!s.isEmpty() && s.size()%2==1 && nums[i]==s.peek()){
                count++;
                continue;
            }else{
                s.push(nums[i]);
            }
        }
        if(s.size()%2==1){
            count+=1;
        }
        return count;
    }
    //394. Decode String
    //repeat string n times
    public static String repeatNTimes(String s, char n) { 
        StringBuilder builder = new StringBuilder(); 
        int num=0;
        if(n>='0' && n<='9'){
            num=  n-'1';
        }
        for (int i = 0; i < n; i++) { 
            builder.append(s); 
        } 
        return builder.toString(); 
    } 

    public static String decodeString(String str) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(Character.isDigit(ch)){//convert character to number
                int num = ch-'0';
                while(Character.isDigit(str.charAt(i+1))&& i+1<str.length()){//ex- '3','4','5' -> 345
                    num = num*10 + str.charAt(i+1)-'0';
                    i++;
                }
                numberStack.push(num);
            }
            else if(ch=='['){
                stringStack.push(sb.toString());
                sb = new StringBuilder();//clear sb
            }else if(ch==']'){
                int n = numberStack.pop();
                StringBuilder temp = new StringBuilder(stringStack.pop());

                //append sb n times in temp
                for(int j=0;j<n;j++){
                    temp.append(sb);
                }

                sb = temp; 

            }else{
                sb.append(ch);
            }
        } 
        return sb.toString();
    }
    
    //First non-repeating character in a stream
    public static String FirstNonRepeating(String str)
    {
        Queue<Character> q = new LinkedList<>(); 
        int[] freq = new int[26];
        StringBuilder sb=new StringBuilder();//String builder TC->O(N), String TC->O(n^2)
        for(int i=0;i<str.length();i++){
             char ch = str.charAt(i);
             q.add(ch);
             freq[ch-'a']++;
             while(!q.isEmpty() && (freq[q.peek()-'a']>1)){
                     q.remove();
                 }   
                 if(q.isEmpty()){
                      sb.append('#');
                 }else{
                     sb.append(q.peek());
                 }
             
        }
         return sb.toString();
    }
    //387. First Unique Character in a String
    public static int firstUniqChar(String str) {
        Queue<Character> q = new LinkedList<>(); 
        int[] freq = new int[26];
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            while(!q.isEmpty() && (freq[q.peek()-'a']>1)){
                q.remove();
            }      
        }   
        return q.isEmpty()?-1 : str.indexOf(q.peek());
    }
    public static void main(String[] args) {
        // int[] nums = {2,6,4,8,10,9,15};
        // System.out.println(findUnsortedSubarray(nums));

        // String str = "(*(**)";
        // System.out.println(checkValidString(str));

        // int[] nums = {-1,3,2,0};
        // System.out.println(find132pattern(nums));

        // String num = "10200";
        // int k=3;
        // System.out.println(removeKdigits(num, k));

        // String[] tokens = {"2","1","+","3","*"};
        // System.out.println(evalRPN(tokens));

        // int[] nums = {1,1,2,2,3,3};
        // System.out.println(minDeletion(nums));

        // String s = "3[a]2[bc]";
        // System.out.println(decodeString(s));

        // String s = "aabccxb";
        // System.out.println(FirstNonRepeating(s));
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));

        
    }
}
