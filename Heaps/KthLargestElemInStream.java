import java.util.*;

public class KthLargestElemInStream {
    static PriorityQueue<Integer> min;
    static int k;

    static List<Integer> getAllKthNumber(int arr[]){
        List<Integer> list = new ArrayList<>();
        for (int val : arr){
            if (min.size() < k){
                min.add(val);
            }else{
                if(val>min.peek()){
                    min.poll();
                    min.add(val);
                }
            }

            if (min.size() >= k){
                list.add(min.peek());
            }else{
                list.add(-1);
            }
            
        }
        return list;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        int k=4;
        min = new PriorityQueue<>();

        List<Integer> res = getAllKthNumber(arr);

        for (int x : res)System.out.print(x + " ");
    }
}
