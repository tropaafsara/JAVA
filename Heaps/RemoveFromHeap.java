import java.util.*;

public class RemoveFromHeap {
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

                x = par;
                par = (x-1)/2;
            }
        }
        public int peek(){
            return arr.get(0);
        }

        public void heapify(int i){ //0(logn)
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i; //minimum is root

            if(left<arr.size() && arr.get(minIdx)>arr.get(left)){// left<arr.size() means, left doesn't have any leaf node
                minIdx = left;
            }
            if(right<arr.size() && arr.get(minIdx)>arr.get(right)){
                minIdx = right;
            }

            if(minIdx!=i){//swap when minIdx is updated. means root needs to be fixed
                //swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public int remove(){ //0(logn)
            int data = arr.get(0);
            //step-1 swap first & last
         int temp = arr.get(0);
         arr.set(0, arr.get(arr.size()-1));
         arr.set(arr.size()-1, temp);

         //step-2 delete last element of arraylist
         arr.remove(arr.size()-1);

         //step-3 heapify
         heapify(0);
         return data;
        }

        public  boolean isEmpty(){
                return arr.size() == 0;
        }
    }
    
    public static void main(String[] args) {
        Heap hp = new Heap();
        hp.add(3);
        hp.add(4);
        hp.add(1);
        hp.add(5);

        while(!hp.isEmpty()){
            System.out.println(hp.peek());
            hp.remove();
        }
    }
}

//convert min heap to max heap  