import java.util.*;
public class Probelems {

    public static void swap(ArrayList<Integer> list, int idx1, int idx2){
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        //print reverse
        for(int i=list.size()-1; i>=0;i--){
            // System.out.println(list.get(i)); //O(n)
        }



        //find max TC-> O(n)
        int max = Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            // if(list.get(i)>max){
            //     max = list.get(i);
            // }

            max = Math.max(max, list.get(i));
        }
        // System.out.println(max);


        //swap 2 numbers
        int idx1 = 2;
        int idx2 = 3;
        System.out.println(list);
        swap(list,idx1,idx2);
        System.out.println(list);
        
    }
}
