import java.util.*;
public class practice{
    public static void main(String[] args) {
        int marks[] = new int[100];//empty
        // int numbers[] = {1,2,3};
        // string fruits[] = {"apple", "mango"}

        Scanner sc = new Scanner(System.in);
        // int phy;
        // phy = sc.nextInt();


        marks[0] = sc.nextInt();
        marks[1] = sc.nextInt();
        marks[2] = sc.nextInt();


        System.out.println("phy: " + marks[0]);
        System.out.println("chem: " + marks[1]);
        System.out.println("eng: " + marks[2]);
        
        int percentage = ((marks[0]+marks[1]+marks[2])/3);
        System.out.println(percentage + "%");
    }
}