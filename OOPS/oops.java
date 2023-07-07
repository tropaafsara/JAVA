public class oops {
    public static void main(String[] args) {
        Pen p1 = new Pen(); //create pen object
        // p1.setColor("Blue");
        p1.setColor("Yellow");
        System.out.println(p1.getColor());
        p1.setTip(5);
        System.out.println(p1.getTip());

        // BankAccount myAccount = new BankAccount();
        // myAccount.username = "potato";
        // myAccount.setPassword("kalalala");
    }
}
// class BankAccount{
//     public String username;
//     private String password;
//     public void setPassword(String pwd){
//         password = pwd;
//     }
// }
class Pen{
    private String color;
    private int tip;
    public String getColor() {
        return this.color;
    }
    void setColor(String newColor){
        color = newColor;
    }
    public int getTip() {
        return this.tip;
    }
    void setTip(int tip){
        this.tip = tip;
    }
}
// class Student{
//     String name;
//     int age;
//     float percentage; //cgpa
//     void calcPercentage(int phy, int math, int chem){
//         percentage=(phy+math+chem)/3;
//     }
// }
