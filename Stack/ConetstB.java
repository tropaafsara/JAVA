import java.util.Scanner;

public class ConetstB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int tc= sc.nextInt();
        for(int k=0;k<tc;k++){
            String s1 = sc.next();
            String s2 = sc.next();
            String s3 = sc.next();
            char c='.';
                    //horizontal
                    if(s1.charAt(0)==s1.charAt(1) && s1.charAt(1)==s1.charAt(2)){
                         c = s1.charAt(0);
                    }
                     if(s2.charAt(0)==s2.charAt(1) && s2.charAt(1)==s2.charAt(2)){
                         c = s2.charAt(0);
                    }
                     if(s3.charAt(0)==s3.charAt(1) && s3.charAt(1)==s3.charAt(2)){
                         c = s3.charAt(0);
                    }
                    //diagonal
                     if(s1.charAt(0)==s2.charAt(1) && s2.charAt(1)==s3.charAt(2)){
                         c = s1.charAt(0);
                    }
                   
                    //vertical
                     if(s1.charAt(0)==s2.charAt(0) && s2.charAt(0)==s3.charAt(0)){
                         c = s1.charAt(0);
                    }
                     if(s1.charAt(1)==s2.charAt(1) && s2.charAt(1)==s3.charAt(1)){
                         c = s1.charAt(1);
                    }
                     if(s1.charAt(2)==s2.charAt(2) && s2.charAt(2)==s3.charAt(2)){
                         c = s1.charAt(2);
                    }
                    
                    
                    
                if(c=='.'){
                    System.out.println("DRAW");
                  }else{
                    System.out.println(c);
                  }
        
            
          
        }
        
    }
}
