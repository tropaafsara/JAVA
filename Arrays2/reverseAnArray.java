public class reverseAnArray {
    public static void reverseAnArray(int n[]) {
        int start=0;
        int last = n.length-1;
        while(start<last){
            int temp = n[last];
            n[last]=n[start];
            n[start]=temp;
            start++;
            last--;
        }

    }
    public static void main(String[] args) {
        int numbers[] ={2,5,8,9,3,5,10};
        reverseAnArray(numbers);
        for(int i=0;i<numbers.length;i++){
            System.out.print(numbers[i]+" ");
        }
    }
}
