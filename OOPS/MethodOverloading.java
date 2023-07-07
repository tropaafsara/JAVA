//Method Overloading = Compile time polymorphism
//bcz in 1st line we need to call 1st function in calc class
//in 2nd line we need to call 2nd function in calc class
//in 3rd line we need to call 3rd function in calc class

public class MethodOverloading {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.sum(1, 2, 3));
        System.out.println(calc.sum(1, 2));
        System.out.println(calc.sum((float)1.0, (float)2.0));
    }
}
class Calculator{
    int sum(int a, int b){
        return a+b;
    }
    float sum(float a, float b){
        return a+b;
    }
    int sum(int a, int b, int c){
        return a+b+c;
    }
}
