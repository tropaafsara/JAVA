import java.util.*;
public class PairSum {
    //pairsum1
    public static boolean pairSum1(ArrayList<Integer> list, int target) {
        //brute force
        // for(int i=0;i<list.size();i++){
        //     for(int j=i+1;j<list.size();j++){
        //         int t = list.get(i)+list.get(j);
        //         if(t==target){
        //             return true;
        //         }
        //     }
        // }
        // return false;

        //2pointer
            int lp=0;
            int rp=list.size()-1;
            while(lp<rp){//or while(li!=rp)
                int sum = list.get(lp)+list.get(rp); 
                if(sum ==target){
                    return true;
                }
                if(sum >target){
                    rp--;
                }else{
                    lp++;
                }
            }
            return false;
    }
    //pairsum2
    public static void pairSum2(ArrayList<Integer> list, int target){
        //brute force of pairsum1 is one answer

        //2 pointer approach
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list);
        System.out.println(pairSum1(list, 5));
        
        
    }
}
