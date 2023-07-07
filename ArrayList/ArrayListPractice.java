import java.util.*;
public class ArrayListPractice {
    public static boolean isMonotonic(ArrayList<Integer> list){
        boolean inc = true;
        boolean dec = false;
        for(int i = 0; i<list.size()-1;i++){   
            //for increasing        
                if(list.get(i)>list.get(i+1)){
                    inc =  false;
                }
                //for decreasing
                if(list.get(i)<list.get(i+1)){
                    dec = false;
                }
        }
        return inc || dec; 
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(2);
        // list.add(3);
        System.out.println(list);
        System.out.println(isMonotonic(list));
    }
}
