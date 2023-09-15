import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class LeetCodeAmazon {
    //2825. Make String a Subsequence Using Cyclic Increments

    public static boolean canMakeSubsequence(String str1, String str2) {
        int i=0, j=0;
        while(i<str1.length() && j<str2.length()){
            /* making 1=0, b=1,........z=25, total 26 characters */
            int s1 = str1.charAt(i)-'a';
            int s2 = str2.charAt(j)-'a'; 

            if(s1 == s2 || s2 == (s1+1)%26){ //z=25, (25+1)%26=0, (condition of cycle)
                j++;
            }
            i++;
        }
        return j==str2.length();
    }
    //
    class pair{
        int a=0,b=0;
        pair(int a,int b)
        {
            this.a = a;
            this.b = b;
        }
    }
    public void swap(pair p1, pair p2, ArrayList<pair> al) {
        pair temp = al.get(p1.b);
        al.set(p1.b, al.get(p2.b));
        al.set(p2.b, temp);
    }
    public int minSwaps(int arr[])
    {
        int n = arr.length;
        ArrayList<pair> al = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            al.add(new pair(arr[i],i));// a = arr[i] , b = i
        }
        Collections.sort(al,(first,second)->(first.a - second.a));
        int count =0;
        for(int i=0;i<n;i++)
        {
            pair p = al.get(i);
            if(p.b!=i)
            {
                swap(p,al.get(p.b),al);
                count++;
                i--;
            }
                
        }
        return count;
    }
    //2405. Optimal Partition of String
    public static int partitionString(String s) {
        HashSet<Character> hs = new HashSet<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(hs.contains(ch)){
                count++;
                hs.clear();
            }
            hs.add(ch);
        }
        return count+1;
    }
    //767. Reorganize String
    public static String reorganizeString(String s) {
        int max=0;
        char maxChar = 'a';
        //count freqency of characters
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
           if(freq[ch-'a']>max){//max will hold the frequency of the most frequently occurring character in the string, and maxChar will hold that character.
            max = freq[ch-'a'];
            maxChar = ch;
           }
        }
        if(max>((s.length()+1)/2)){
            return "";
        }

        char[] res = new char[s.length()];
        int idx = 0;

        //on even idx store char that has max freq until max is 0
        while(freq[maxChar-'a']!=0){
            res[idx] = maxChar;
            idx+=2;
            freq[maxChar-'a']--;
        }
        //now that char is used, so it will become 0
        for(int i=0;i<26;i++){
            while(freq[i]>0){
                if(idx>=s.length()){//after using the max freq character we've reached the end of the array
                    idx=1;//now start placing from idx 1
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                freq[i]--;
            }
        }
        return new String(res);

    }
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "ad";
        // System.out.println(canMakeSubsequence(str1, str2));
        // String s = "abacaba";
        // System.out.println(partitionString(s));

        String s = "aab";
        System.out.println(reorganizeString(s));
    }
}
