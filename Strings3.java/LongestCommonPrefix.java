import java.util.Arrays;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs){
        Arrays.sort(strs);//strs = {"flight","flow","flower"}
        String res="";
        String f = strs[0];
        String l = strs[strs.length-1];
        for(int i=0;i<strs[0].length();i++){
            if(f.charAt(i)!=l.charAt(i)){
                return res;
            }else{
                res +=l.charAt(i);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
