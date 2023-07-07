import java.util.*; 
public class typePromotion {
    public static void main(String[] args) {
        /* short a = 5;
        byte b = 25;
        char c ='l';
        byte bt = a+b+c;
        System.out.println(bt); */
        //if operands are long, float, double, the whole expression will be   converted repectively long, float, double
        
        
        /* int a =2;
        float b = 3.34f;
        long  c = 34;
        double d = 30;
        double r = a+b+c+d;//a,b,c will be converted into double
        // int r = a+b+c+d;//error, abcd is already double
        System.out.println(r); */

        byte b = 5;
        byte a = (byte)(b*2);//b will be converted i to int
        // b= (byte) (b*2);//cannot put int in byte cz byte has  smaller place than int
        // b = b*3;
        System.out.println(a);

    }
}
