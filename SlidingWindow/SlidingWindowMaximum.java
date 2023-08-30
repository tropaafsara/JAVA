import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        
        ArrayList<Integer> al = new ArrayList<>();
        int i=0, j=0;
        Deque<Integer> q = new LinkedList<>();
        while(j<nums.length){
            while(!q.isEmpty() && q.peekLast()<nums[j]){
                q.pollLast();
            }
            q.addLast(nums[j]);
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){//slide the indow
                 al.add(q.peekFirst());//ans
                if(nums[i]==q.peekFirst()){//remove i
                    q.pollFirst();
                }
                i++;
                j++;
            }
        }
        int[] v = new int[al.size()];
        for(int l=0;l<al.size();l++){
            v[l] = al.get(l);
        }
        return v;
    }
    public static void main(String[] args) {
        int[] nums ={1,3,1,2,0,5};
        int k =3;
        int[] v = maxSlidingWindow(nums, k);
        for(int i=0;i<v.length;i++){
            System.out.print(v[i]+" ");
        }
    }
}
