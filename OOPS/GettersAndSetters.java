public class GettersAndSetters {
    public static void main(String[] args) {
        Pen p1 = new Pen();
        p1.setColor("Yellow");
        System.out.println(p1.getColor());

        p1.setTip(5);
        System.out.println(p1.getTip());
    }
}
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
