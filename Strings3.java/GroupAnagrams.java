import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class GroupAnagrams {
    public static boolean anagram(String s1, String s2){

        if(s1.length()!=s2.length()){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s1.length();i++){
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);//if number deosn't exists then freq =0, if exists freq=1;

        }
        for(int i=0; i<s2.length();i++){
            char ch = s2.charAt(i);
            if(map.get(ch)!=null){
                if(map.get(ch)==1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch)-1);
                }
            }else{
                return false;
            }
        }
        return map.isEmpty();
    }

    public static List<List<String>>  groupAnagrams(String[] strs){
        HashMap<String,List<String>>  map = new HashMap<>();
        if(strs.length==0){
            return new ArrayList<>();
        }
        for (String word : strs) {
            // System.out.println(word);
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            // System.out.println(chars);
            String sortedWord = new String(chars);
            if(!map.containsKey(sortedWord)){
                map.put(sortedWord,new ArrayList<>());
            }
            map.get(sortedWord).add(word);
        }
        return new ArrayList<>(map.values());
    }
  
    public static void main(String[] args) {
        // String s1 = "listen";
        // String s2 = "silent";
        // System.out.println(anagram(s1, s2));
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
}
