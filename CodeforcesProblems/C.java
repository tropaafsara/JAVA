import java.util.Scanner;
//Word on the Paper
public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder word = new StringBuilder();
        for(int i=0;i<t;i++){
            char[][] grid = new char[8][8];
            for(int j=0;j<8;j++){
                String line = sc.next();
                for(int k=0;k<8;k++){
                    grid[j][k] = line.charAt(k);
                    if(grid[j][k]!='.'){
                        word.append(grid[j][k]);
                    }
                    
                }
            }
            
            System.out.println(word.toString());
            word.setLength(0);
            
        }
    }
}
