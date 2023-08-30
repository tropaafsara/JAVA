public class BitManipul {
    public static int getIthBit(int n, int i){
        int bitMask = 1<<i;
        if((n & bitMask) ==0){
            return 0;
        }else{
            return 1;
        }
    }
    public static int setIthBit(int n, int i){
        int bitMask = 1<<i;
        return n|bitMask;
    }
    public static int clearIthBit(int n, int i){
        // int bitMask = ~(1<<i);
        // return n & bitMask;
        return n|0;
    }
    public static int updateIthBit(int n, int i, int newBit){
        //you'll be given 0 or 1 to update

        // if(newBit==0){
        //     clearIthBit(n, i);
        // }else{
        //     setIthBit(n, i);
        // }

        n = clearIthBit(n, i);
        int bitMask = newBit<<i;
        return n|bitMask;
    }
    public static void main(String[] args) {
        System.out.println(clearIthBit(10, 2));
    }
}
