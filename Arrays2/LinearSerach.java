public class LinearSerach {
    public static int LinearSerach (int n[], int k) {
        for(int i=0;i<=n.length;i++){
            if(n[i]==k){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int numbers[]={2,3,4,56,6,72,10};
        int key =10;
        int index = LinearSerach(numbers, key);
        if(index ==-1){
            System.out.println("NOT FOUND");
        }
        System.out.println(index);
    }
}
