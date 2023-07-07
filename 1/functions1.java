public class functions1 {
    public static int product(int a, int b){
        int r = a*b;
        return r;
    }

    public static int factorial(int n){
        int f =1;
        for(int i=1;i<=n;i++){
            f = f*i;
        }
        return f;
    }

    //binomial co=efficient
    public static int binomialCoefficient(int x, int y){
        int x_fact = factorial(x);
        int y_fact = factorial(y);
        int xmy_fact = factorial(x-y);
        int nCr = x_fact/(y_fact*xmy_fact);
        return nCr;
    }
    public static void main(String[] args) {
        int num1=3, num2=4;
        int prod = product(num1,num2);
        System.out.println("a*b = "+ prod);
        System.out.println(factorial(5));

        System.out.println(binomialCoefficient(5, 2));
        
    }
    
}
