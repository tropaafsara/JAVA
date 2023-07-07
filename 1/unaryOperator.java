public class unaryOperator {
    public static void main(String[] args) {
        int a = 12;
        int b = a++;//++a = a will use and then increase by 1 
        // int b= ++a;//++a = a will increase by 1 then use
        System.out.println(a);
        System.out.println(b);

        int c = 10;
        int d = --c;
        System.out.println(c);
        System.out.println(d);
    }
}
