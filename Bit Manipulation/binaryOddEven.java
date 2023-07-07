public class binaryOddEven {
    public static void oddOrEven(int n){
        int bitMask  =  1;
        if((n & bitMask) == 0){
            //even
            System.out.println("Even Number");
        }else{
            System.out.println("Odd Number");
        }
    }
    public static void main(String[] args) {
        //0 = 000
        //1 = 001
        //2 = 010
        //3 = 011
        //4 = 100

        //odd = LSB = 1
        //even = LSB = 0

        //bit mask = 1  where 1 = 00000000001, it's LSB =1;

        oddOrEven(3);
        oddOrEven(4);
    }
}
