public class dToB {
    public static void decimalToBinary(int n){
        int binaryNumber = 0;
        int i = 0;

        while(n>0){
            int rem = n%2;
            binaryNumber = binaryNumber+(rem*(int)Math.pow(10,i));
            i++;
            n = n/2 ;
        }
        System.out.println(binaryNumber);

    }
    public static void main(String[] args) {
        decimalToBinary(5);
        
    }
    
}
