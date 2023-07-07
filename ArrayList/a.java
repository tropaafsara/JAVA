import java.util.*;
public class a {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();//<> is determines the datatype
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

    list.add(1,9); //idx =1 , val = 9
        System.out.println(list);

        //get elemnt
        int element = list.get(2);
        // System.out.println(element);

        //delete element
        list.remove(2);
        System.out.println(list);

        //set
        list.set(2,10);
        System.out.println(list);
        System.out.println(list.size());//size of arraylist
        System.out.println();
        for(int i=0; i<list.size();i++){
            
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

        //contains
        System.out.println();
        System.out.println(list.contains(1));
        System.out.println(list.contains(11));


        

    }

}
