public class functionOverloading {

    //function overloading using parameters
    /* public static int sum(int a, int b){
        return a+b;
    }
    public static int sum(int a, int b, int c){
        return a+b+c;
    } */


    //function overloading using dataypes

    public static int sum (int a, int b){
        return a+b;
    }
    public static float sum (float a, float b){
        return a+b;
    }
    public static void main(String[] args) {
        /* System.out.println(sum(3,2));
        System.out.println(sum(3,2, 3)); */
        System.out.println(sum(3,3));
        System.out.println(sum(3.0f,3.1f));
    }
    
}
