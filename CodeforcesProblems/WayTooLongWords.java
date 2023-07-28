import java.util.Scanner;

public class WayTooLongWords {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            for(int i=0;i<n;i++){
                String s = sc.next();
                if(s.length()<=10){
                    System.out.println(s);
                }else{
                    char a = s.charAt(0);
                    char b = s.charAt(s.length()-1);
                    int count =0;
                    for(int j=1;j<s.length()-1;j++){
                        count++;
                    }
                    System.out.println(a+""+count+""+b);
                }
            }

    }
}
