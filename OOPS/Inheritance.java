public class Inheritance {
    public static void main(String[] args) {
        // Fish shark = new Fish();
        // shark.eat();




        Dog dobby = new Dog(); 
        dobby.eat();
        dobby.legs = 4; 
        System.out.println(dobby.legs);
    }
}
//Base class / Parent class
class Animal{
    void eat(){
        System.out.println("eats");
    }
    void breaths(){
        System.out.println("breaths");
    }
}
//Derived class / child class
class Fish extends Animal{
    int fins;
    void swims(){
        System.out.println("swims");
    }
}

//multi level inheritance
class Mammal extends Animal{
    int legs;
}
class Dog extends Mammal{
    String breed;
}