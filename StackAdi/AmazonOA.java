import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class AmazonOA {
    public static ArrayList<Integer> nsr(int[] arr){
        ArrayList<Integer> al = new ArrayList<>();
        int n = arr.length-1;
        Stack<Integer> s = new Stack<>();
        for(int i=n;i>=0;i--){
            if(s.isEmpty()){
                al.add(-1);
            }
            else if(!s.isEmpty()&& s.peek()<arr[i]){
                al.add(1);
            }
            else if(!s.isEmpty()&& s.peek()>=arr[i]){
                while(!s.isEmpty()&& s.peek()>=arr[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                    al.add(-1);
                }else{
                    al.add(1);
                }
            }
            s.push(arr[i]);
        }
        return al;
    }
    public static ArrayList<Integer> nsl(int[] arr){
        ArrayList<Integer> al = new ArrayList<>();
        int n = arr.length-1;
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<n;i++){
            if(s.isEmpty()){
                al.add(-1);
            }
            else if(!s.isEmpty()&& s.peek()<arr[i]){
                al.add(1);
            }
            else if(!s.isEmpty()&& s.peek()>=arr[i]){
                while(!s.isEmpty()&& s.peek()>=arr[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                    al.add(-1);
                }else{
                    al.add(1);
                }
            }
            s.push(arr[i]);
        }
        return al;
    }

    public static int solve(int[] arr){
        ArrayList<Integer> a = nsr(arr);
        // for(int i=0;i<a.size();i++){
        //     System.out.print(a.get(i)+" ");
        // }
        // System.out.println();
        ArrayList<Integer> b = nsl(arr);
        // for(int i=0;i<b.size();i++){
        //     System.out.print(b.get(i)+" ");
        // }
        int k=0;
        for(int i=0;i<arr.length-1;i++){
            if((a.get(i)+b.get(i))>0){
                k++;
            }
        }
        return k;
    }
    public static void main(String[] args) {
        // int[] arr = {1, 2, 8, 3, 7, 4, 6, 5};
        // System.out.println(solve(arr));
        // System.out.println(solve(arr));


    }
}
