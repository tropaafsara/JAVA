
public class decimalToJava {
    
 /*    public static void decimalToBinary(int n){
        int decimal = 0;
        int i = 0;
        while(n>0){
            int lastDigit = n%10;
            decimal = decimal+(lastDigit*(int)Math.pow(2,i));
            i++;
            n = n/10;
            
        }
        System.out.println("Decimal of binary is = "+decimal);
    }
    public static void main(String[] args) {
        decimalToBinary(1011);
    } */







/*  Since the function only produces output through the println statement and 
doesn't return any value, it's appropriate to declare the return type as void. */

    public static int decimalToBinary(int n){
        int decimal = 0;
        int i = 0;
        while(n>0){
            int lastDigit = n%10;
            decimal = decimal + (lastDigit * (int)Math.pow(2, i));
            i++;
            n = n/10;
        }
        return decimal;
        // System.out.println(decimal);
    }
    public static void main(String[] args) {
        System.out.println(decimalToBinary(1011));
    }
    
}
