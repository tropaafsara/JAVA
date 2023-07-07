public class StringPalindrome {
    


    public static boolean isPalindrome(String s){
        int n= s.length();
        for(int i=0; i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-1-i)){
                System.out.println("Not a palindrome");
                return false;
            }
        }
        System.out.println("palindrome");
        return true;
    }




    public static void main(String[] args) {
        String str = "racecar";
        System.out.println(isPalindrome(str));
    }
}
