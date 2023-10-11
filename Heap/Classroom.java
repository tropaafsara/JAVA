import java.util.ArrayList;

public class Classroom {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data){
            //add at last idx
            arr.add(data);

            int x = arr.size()-1; //child idx
            int par = (x-1)/2;
            /* A tree has n nodes, traversing all levels causes 0(logn) */
            while(arr.get(x)<arr.get(par)){//O(logn) 
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x-1)/2;
            }
        }
        /* In minheap peek=min ele, in maxheap peek=max ele */
        public int peek(){
            return arr.get(0);
        }


        //remove 
        public void heapify(int i){//fix heap
            int minIdx = i;
            int left = 2*i+1;
            int right = 2*i+2;

            if(left<arr.size() && arr.get(minIdx)>arr.get(left)){
                minIdx = left;
            }
            if(right<arr.size() && arr.get(minIdx)>arr.get(right)){
                minIdx = right;
            }
            if(minIdx!=i){
                //swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }
        public int remove(){
            int data = arr.get(0);
            //step-1 - swap first & last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //step-2 - delete last
            arr.remove(arr.size()-1);

            //step-3 - heapify
            heapify(0);
            return data;
        }
        public boolean isEmpty(){
            return arr.size()==0;
        }
    }
    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
        while(!h.isEmpty()){//will print ascending order cz h.peek is always min in min heap
            System.out.println(h.peek());
            h.remove();
        }
    }
}
