import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
/* Explanation for why we need an ArrayDeque instead of a simple Queue:

We have made use of an ArrayDeque in this question because we have made an assumption that we will always store the max element in FRONT of the queue. When we hit our window size, we just get the FRONT of the queue to get the max element for the window.

If we would have not taken an ArrayDeque and used a normal Queue instead, in that case we would have violated the assumption that we made. For example assume we have 

I/P - arr:[6,4,5,4], k =3
O/P - [6,5]


If we have taken ArrayDeque then our queue for the first window would look like - 
[6] i=0,j=0
[6,4] i=0,j=1
[6,5] i=0,j=2

which is correct because 6 > 5 and 5 > 4, so we remove 4 from the queue .

But if we would have taken a normal Queue instead then we would have - 
[6] i=0,j=0
[6,4] i=0,j=1
[6,4,5] i=0,j=2

which is incorrect since 4 < 5 and it violates our assumption that max element will always be at the FRONT.

then, for second window i=1,j=3 our queue would look like-
[4,5,4] and we would get the O/P as [6,4] which is incorrect.  */

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        
        ArrayList<Integer> al = new ArrayList<>();
        int i=0, j=0;
        Deque<Integer> q = new LinkedList<>();
        while(j<nums.length){
            while(!q.isEmpty() && q.peekLast()<nums[j]){
                q.pollLast();//greater element will be stored in front of queue
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
