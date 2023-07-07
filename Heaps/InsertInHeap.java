import java.util.*;

public class InsertInHeap {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data){ //0(logn)
            //add at last idx
            arr.add(data);

            int x = arr.size()-1; // x is child index
            int par = (x-1)/2; // parent index

            while(arr.get(x)<arr.get(par)){ //O(logn) cz in tree there's (logn) levels. so we'll compare the child with no. of levels
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par)) ;
                arr.set(par, temp);
            }
        }
        public int peek(){
            return arr.get(0);
        }
        
    }
    public static void main(String[] args) {
        
    }
}
