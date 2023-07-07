import java.util.ArrayList;
import java.util.Collections;
public class Sorting {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(6);
        list.add(4);
        list.add(39);
        list.add(5);
        list.add(1);

        System.out.println(list);
        Collections.sort(list); //ascending order
        System.out.println(list);

        //descending
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);


    }
}
