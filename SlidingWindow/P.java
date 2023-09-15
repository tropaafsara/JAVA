import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P {
    public static int lenOfLongSubarr(int arr[], int k){
        for(int i=0;i<arr.length;i++){
            arr[i] = arr[i]%2 == 0 ?  0 : 1;
        }
        int i=0;
        int j=0;
        int sum=0;
        int max =0;
        int res=0;
        while(j<arr.length){
            sum+=arr[j];
            while(sum==k){
                max++;
                sum-=arr[i];
                i++;
            }
            res+=max;
            j++;
        }
        return max;
        
    } 
    public static int helper(String s, char ch, int k){
        int i=0;
        int j=0;
        int ans = -1;
        while(j<s.length()){
            if(ch!=s.charAt(j)){
                k--;
            }
            while(k<0){
                if(ch==s.charAt(i)){
                    i++;
                }else{
                    k++;
                    i++;
                }
            }
            ans = Math.max(ans, j-i+1);
            j++;

        }
        return ans;
    }
    public static int maxConsecutiveAnswers(String answerKey, int k){
        return Math.max(helper(answerKey,'T', k), helper(answerKey,'F', k));
    }
    public static void main(String[] args) {
       String s = "TTFTTFTT";
       System.out.println(maxConsecutiveAnswers(s,1));


    }
}
