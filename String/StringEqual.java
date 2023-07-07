public class StringEqual {
    public static void main(String[] args) {
        String s1= "Tony";
        String s2= "Tony";
        String s3= new String("Tony");
        // if(s1==s2){
        //     System.out.println("(s1 & s2) Strigns are Equal");
        // }
        // if(s1==s3){
        //     System.out.println("(s1 & s3) Strigns are Equal");
        // }else{
        //     System.out.println("(s1 & s3) Strigns are not Equal");
        // }

        if(s1.equals(s3)){
            System.out.println("(s1 & s3) Strigns are Equal");
        }else{
            System.out.println("(s1 & s3) Strigns are not Equal");
        }
    }
}
