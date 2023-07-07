import java.util.ArrayList;

public class Practice7 {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void insert(int data){
            arr.add(data);//store in last
            int x = arr.size()-1;
            int par = (x-1)/2;

            while(arr.get(par)>arr.get(x)){
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par,temp);
            }
        }
        public int peek(){
            return arr.get(0);
        }

        public void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;

            if(arr.get(left)<arr.get(minIdx) && left < arr.size()){
                minIdx = left;
            }
            if(arr.get(right)<arr.get(minIdx) && right < arr.size()){
                minIdx = right;
            }
        }

        public void remove(){
            int data = arr.get(0);
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);

            arr.remove(arr.size()-1);

            heapify(0);
             
            
        }

        public  boolean isEmpty(){
            return arr.size() == 0;
        }
    }


    public static void main(String[] args) {
        Heap hp = new Heap();
        hp.insert(3);
        hp.insert(4);
        hp.insert(1);
        hp.insert(5);

        while(!hp.isEmpty()){
            System.out.println(hp.peek());
            hp.remove();
        }
    }
}
