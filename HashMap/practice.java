import java.util.HashMap;

public class practice {
    public static void main(String[] args) {
        int arr[] = {2,2,1,1,1,2,2};
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
        }
    }
}
