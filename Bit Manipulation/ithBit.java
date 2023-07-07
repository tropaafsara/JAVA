public class ithBit {
    public static int getIthBit(int n, int i){
       
        int bitMask = 1<<i; //left shift 1 to ith
        if((n & bitMask)==0){
            return 0;
        }else{
            return 1;
        }
    }
    public static int setIthBit(int n, int i){
       
        int bitMask = 1<<i; //left shift 1 to ith
        return n | bitMask;
    }
    public static int clearIthBit(int n, int i){
       
        int bitMask = ~(1<<i); //
        return n & bitMask;
    }
    public static int updateIthBit(int n, int i, int newBit){
        // if(newBit == 0){
        //     return clearIthBit(n, i);

        // }else{
        //     return setIthBit(n, i);
        // }


        //if NB = 0 then clear, if NB =1 then set
         n = clearIthBit(n, i);
         int BitMask = newBit <<i;
         return n| BitMask;
    }
    public static int clearBits(int n,  int i){
        int bitMask = (~0)<<i;
        return n&bitMask;
    }
    public static boolean isPowerOfTwo(int n){
        return (n&(n-1))==0;
    }
    public static int countSetBits(int n){
        int count = 0;
        while(n>0){
            if((n&1)!=0){ //check LSB
                count++;
            }
            n = n>>1;
        }
        return count;
    }
    public static void main(String[] args) {
        //ith bit, check ith bit 0 or 1 
        //10 = 1010
        // System.out.println(getIthBit(10, 3));
        // System.out.println(setIthBit(10, 2));
        // System.out.println(clearIthBit(10, 1));
        // System.out.println(updateIthBit(10, 2, 1));
        // System.out.println(clearBits(15, 2));
        // System.out.println(isPowerOfTwo(15));
        System.out.println(countSetBits(10));
    }

}
