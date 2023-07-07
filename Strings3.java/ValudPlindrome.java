public class ValudPlindrome {
    public static boolean isPalindrome(String s) {
        s= s.toLowerCase();
        s= s.replace(" ",""); 
        s= s.replaceAll("[^\\sa-zA-Z0-9]", "");
        for(int i =0; i<s.length()/2;i++){
            
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
            
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panamaa"; 
        System.out.println(isPalindrome(s));   
    }
}
