import java.util.*;

public class ContainerWithMostWater {
    public static int storeWater(ArrayList<Integer> height ){
        // //brute force TC -> O(n^2)
        // int max = 0;
        // for(int i=0;i<height.size();i++){
        //     for(int j= i+1;j<height.size();j++){
        //         int h= Math.min(height.get(i),height.get(j));
        //         int width = j-i;
        //         int water = h*width;
        //         if(max<water){
        //             max=water;
        //         }

        //     }
        // }
        // return max;



        //2 pointer approach TC -> O(n)
        int maxWater = 0;
        int lp=0;
        int rp= height.size()-1;
        while(lp<rp){
            //calc water area
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp-lp;
            int currentWater = ht*width;
            maxWater = Math.max(currentWater,maxWater);

            //update ptr
            if(height.get(lp)<height.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(height);

        System.out.println(storeWater(height));
        
    }
}
