import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


public class StackQueue {
    public static Queue<Integer> q1 = new LinkedList<Integer>();
    public static Queue<Integer> q2 = new LinkedList<Integer>();
    public static Stack<Integer> s1 = new Stack<>();
    public static Stack<Integer> s2 = new Stack<>();

    //implement stack using 2 queue
    public static void push(int val){
        q2.add(val);
        
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }

        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }

    }
    public static int pop(){
        if(q1.isEmpty()){
            return -1;
        }
        int top = q1.peek();
        q1.remove();
        return top;

    }

    //implement queue using 2 stacks
    public static void push1(int val){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(val);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    } 
    public static int pop1(){
        if(s1.isEmpty()){
            return -1;
        }
        int top = s1.peek();
        s1.pop();
        return top;

    }
    //
    // public static String backspaceCompare(String str){
    //     Stack<Character> s = new Stack<>();
    //     StringBuilder sb = new StringBuilder();
    //     for(int i=0;i<str.length();i++){
    //         char ch = str.charAt(i);
    //         if(!s.isEmpty() && ch==')'){
    //             while(!s.isEmpty() && ch=='('){
    //                 s.pop();
    //             }
    //         }else{
    //             s.push(ch);
    //         }

    //     }
    // }


    static class Row implements Comparable<Row>{
        int sum ;
        int i;
        public Row(int sum, int idx){
            this.sum = sum;
            this.i = idx;
        }
        @Override
        public int compareTo(Row r2){
            if(this.sum==r2.sum){
                return this.i-r2.i;
            }else{
                return this.sum-r2.sum;
            }
        }
    }
    public static boolean a(String s, String goal){
        StringBuilder sb = new StringBuilder(s);
        int n = s.length();
        while(n>0){
            if(sb.toString().equals(goal)){
                return true;
            }
            char ch = s.charAt(0);
            sb.deleteCharAt(0);
            sb.append(ch);
            n--;
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab"
        

    }
}
