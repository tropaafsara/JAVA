import java.util.*;
public class MultiD {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>(); //integer type arraylist is stored in a new arraylist
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(1);
        list.add(2);
        mainlist.add( list);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        mainlist.add(list2);


        System.out.println(mainlist);

    for(int i=0;i<mainlist.size();i++){
         ArrayList<Integer>   currentList =   mainlist.get(i);
        //  System.out.println(currentList.get(i));
         for(int j=0;j<currentList.size();j++){
            System.out.print(currentList.get(j)+" ");
         }
         System.out.println();
    }
    
    }
}
