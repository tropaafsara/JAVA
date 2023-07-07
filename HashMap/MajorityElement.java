import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
            // int arr[] = {1,3,2,5,1,3,1,5,1};
            int arr[] = {2,2,1,1,1,2,2};
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<arr.length;i++){
                // if(map.containsKey(arr[i])){
                //     map.put(arr[i], map.get(arr[i])+1);//map.get(arr[i]) = value of the key
                // }else{
                //     map.put(arr[i],1);
                // }

                map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            }
            // Set<Integer> keySet = map.keySet();
            for (Integer key : map.keySet()) {
                if(map.get(key)>arr.length/2){//map.get(key) = value of the key
                    System.out.println(key);
                }
            }


            // List<Integer> list =new ArrayList<>();   
            // for (Integer key : map.keySet()) {
            //     if(map.get(key)>arr.length/3){//map.get(key) = value of the key
            //         list.add(key);
            //     }
                
            // } 
            // return list;
    }
}
