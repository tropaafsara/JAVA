public class Substring {
    

    public static String subsString(String str, int si, int ei) {
        String str2 ="";
        for(int i=si;i<ei;i++){
            str2+= str.charAt(i);
        }
        return str2;
    }
    public static void main(String[] args) {
        String str = "Hello World";
        // System.out.println(str.substring(0,5));;
        System.out.println(subsString(str, 0, 7));;
    }
}
