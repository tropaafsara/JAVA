

public class reverseAnArray {
    public static void reverseTheArray(int arr[]){
       

        int f =0;
        int l = arr.length-1;
        while(f<=l){
            int temp = arr[f];
            arr[f] = arr[l];
            arr[l] = temp;
            f++;
            l--;
        }
    }

 



    public static void main(String[] args) {
        int arr[]={2,4,6,2,8,10,11};
        reverseTheArray(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        
    }
    
}
