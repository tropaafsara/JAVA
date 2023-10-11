public class This {
    static class Pen{
        String color;
        
        public void printColor(){
            System.out.println(this.color);
            //this keyword refers to the current object in a method or constructor.
            /* (this.) Ei printcolor function k jei object call korbe oi object er color print krbe */
            /* this will tell ei function k kon object call krse or access korar try kortese */
        }
    }
    static class Student{
        String name;//1
        int age;
        Student(String name, int age){
            this.name = name;//s1.name = "a"; this.name is coming from String name, name is coming from parameter
            this.age = age;//s1.age =22;
        }
    }
    static class Student2{
        String name;//1
        int age;
        //copy constructor
        Student2(Student s2){
            this.name = s2.name;
            this.age = s2.age;
        }
    }

    public static void main(String[] args) {
        Pen p1 = new Pen();//when we write new, in memory heap there allocates a place, in that place whole object will be stored 
        p1.color = "Blue";

        Pen p2 = new Pen();
        p2.color = "Black";

        p1.printColor();
        p2.printColor();


        //
        Student s1 = new Student();
        s1.name = "a";
        s1.age =22;
        
    }
}
