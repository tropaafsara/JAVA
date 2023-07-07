public class practice3 {
    public static int factorial(int n){
        int f = 1;
        for(int i=1;i<=n;i++){
            f=f*i;
        }
        return f;
    }

    public static int binomialCoefficient(int x, int y){
        int fact_x = factorial(x);
        int fact_y = factorial(y);
        int fact_xmy = factorial(x-y);
        int nCr = fact_x/ (fact_y*fact_xmy);
        return nCr;
    }
    public static void main(String[] args) {
        System.out.println(binomialCoefficient(4, 2));
        
    }
    
}
