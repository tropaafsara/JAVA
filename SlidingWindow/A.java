import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class A {
    //max subarray sum of size k
    public static int maxSubarrayofSizek(int[] arr, int k){
        int sum = 0;
        int i=0;
        int j=0;
        int max = Integer.MIN_VALUE;
        while(j<arr.length){
            sum+=arr[j];
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                max = Math.max(max, sum);
                sum=sum-arr[i];
                i++;
                j++;
                
            }
        }
        return max;
    }
    //1st -ve in every min size of k
    public static List<Integer> firstNegSubarrayofSizek(int[] arr, int k){
        int i=0;
        int j=0;
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        while(j<arr.length){
            if(arr[j]<0){
                l1.add(arr[j]);
            }
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                if(l1.size()==0){
                    l2.add(0);
                }else{
                    l2.add(l1.get(0));
                    if(arr[i]<0){
                        l1.remove(l1.get(0));
                    }
                }
                i++;
                j++;
                
            }
        }
        return l2;
    }
    //Count occurance of anagram
    public static int occuranceOfAnagram(String txt,String pat){
        int i = 0;
        int j = 0;
        int k = pat.length();//window size
        int ans = 0;//return 
        HashMap<Character, Integer> map = new HashMap<>();
        //count frequency of pat
        for (int z = 0; z < pat.length(); z++) {
            map.put(pat.charAt(z), map.getOrDefault(pat.charAt(z), 0) + 1);
        }
        int cnt = map.size();//so that we don't need to iterate through the map
        while (j < txt.length()) {
            if (map.containsKey(txt.charAt(j))) {
                char currentChar = txt.charAt(j);
                int count = map.get(currentChar); //freq or value
                count -= 1;//freq
                map.put(currentChar, count);
                if (count == 0)
                    cnt--;
            }
            if (j - i + 1 < k)
                j++;
            else if (j - i + 1 == k) {
                if (cnt == 0) {//all the letters on map is 0, means it's anagram
                    ans++;
                }
                if (map.containsKey(txt.charAt(i))) {
                    char currentChar = txt.charAt(i);
                    int count = map.get(currentChar);
                    count += 1;
                    map.put(currentChar, count);
                    if (count == 1) {
                        cnt++;
                    }
                }
                i++;
                j++;
            }
        }
        return ans;
        
    }
    //1456. Maximum Number of Vowels in a Substring of Given Length
    public static int maxVowels(String s, int k) {
        int i=0, j=0;
        int count=0;
        int max = -1;
        while(j<s.length()){
            char ch = s.charAt(j);
            if(ch=='a'|| ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                count++;
            }
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                max = Math.max(max, count);
                char ch2 = s.charAt(i);
                if(ch2=='a'|| ch2=='e' || ch2=='i' || ch2=='o' || ch2=='u'){
                    count--;
                }
                i++;
                j++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        //max subarray sum of size k
        // int[] arr = {1,5,4,2,9,9,9};
        // int subarray_size = 3;
        // int r = maxSubarrayofSizek(arr, subarray_size);
        // System.out.println(r);


        //1st -ve in every min size of k
        // int[] arr = {12,-1,-7,8,-15,30,13,28};
        // int subarray_size = 3;
        // List<Integer> a = firstNegSubarrayofSizek(arr, subarray_size);
        // for(int i=0;i<a.size();i++){
        //     System.out.print(a.get(i)+" ");
        // }
        // System.out.println();


        //Count occurance of anagram
        // String txt = "forxxorfxdofr";
        // String pat="for";
        // int res = occuranceOfAnagram(txt,pat);
        // System.out.println(res);


        String s = "abciiidef";
        System.out.println(maxVowels(s, 3));
    }
}
