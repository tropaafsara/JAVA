public class binaryBitwiseOperation {
    public static void main(String[] args) {
        System.out.println(( 5 & 6 )); //4   & = Binary And
        System.out.println(( 5 | 6 )); //7   | = Binary And
        System.out.println(( 5 ^ 6 )); //3   ^ = Binary XOR
        System.out.println(( ~0 )); //-1   ~ = Binary 1's complement
        System.out.println(( 5<<2 )); //20   << = Binary Left Shift a<<b = a*2^b
        System.out.println(( 6>>1 )); //3   << = Binary Right Shift a>>b = a/2^b
    }
}
