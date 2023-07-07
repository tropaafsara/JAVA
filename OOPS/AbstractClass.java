public class AbstractClass {
    public static void main(String[] args) {
        // Horse h = new Horse();
        // h.eat();
        // h.walk();

        // Chicken c = new Chicken();
        // c.eat();
        // c.walk();
        // // Animal a = new Animal(); // cannot make object/instance of abstact Animal class
        // System.out.println(h.color); // parent class constructor gets called first
        // System.out.println(c.color);



        Mustang myHorse = new Mustang();
        //Animal -> Horse -> Mustang
    }
}
abstract class Animal{
    String color;
    Animal(){
        color="red";
        System.out.println("Animal constructor called");
    }
    void eat(){
        System.out.println("eats");
    }
    abstract void walk();   //idea
}
class Horse extends Animal{
    Horse(){
        System.out.println("Horse Constructor called");
    }
    void changeColor(){
        color="brown";
    }
    void walk(){
        System.out.println("walks on 4 legs"); //implementation
    }
}
class Mustang extends Horse{
        Mustang(){
            System.out.println("Mustang constructor called");
        }
}
class Chicken extends Animal{
    Chicken(){
        System.out.println("Chicken constructor called");
    }
    void changeColor(){
        color="yellow";
    }
    void walk(){
        System.out.println("walks on 2 legs");//implementation
    }
}