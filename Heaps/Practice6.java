import java.util.ArrayList;

public class Practice6 {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            arr.add(data);

            int x = arr.size()-1;
            int par = (x-1)/2;

            while(arr.get(x)<arr.get(par)){
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                

                x= par;
                par = (x-1)/2;
            }
             
        }

        public int peek(){
            return arr.get(0);
        }

        public void heapify(int i){
            
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;
            
            if(arr.get(minIdx)>arr.get(left) && left<arr.size()){
                minIdx = left;
            }
            if(arr.get(minIdx)>arr.get(right) && left<arr.size()){
                minIdx = left;
            }

            if(minIdx!=i){//swap when minIdx is updated. means root needs to eb fixed
                int temp = arr.get(minIdx);
                arr.set(minIdx, i);
                arr.set(i, temp);

                heapify(minIdx);

            }
            
        }

        public int remove(){
            //swap
            int data = arr.get(0);
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //delete last element of array
            arr.remove(arr.size()-1);

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
        h.add(4 );
        h.add(1);
        h.add(5);

        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }
    }
}
