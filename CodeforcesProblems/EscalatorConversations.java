import java.util.Scanner;

public class EscalatorConversations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int count=0;
            int n = sc.nextInt();//number of people
            int m = sc.nextInt();//number of steps
            int k = sc.nextInt();//height difference between neighboring steps
            int H = sc.nextInt();//Vlad's height
            int[] arr = new int[n];
            for(int i=0;i<n;i++ ){
                arr[i] = sc.nextInt();
            }
            int[] arr2 = new int[m];
            for(int l=1;l<m;l++){
                    arr2[l] = l;
            }

            for(int j=0;j<n;j++){
                int diff = Math.abs(H-arr[j]);
                //Find a pair with the given difference
                int left =0;
                int right =1;
                while(left<right && right<arr2.length){
                    int diff2 = (arr2[right]-arr2[left])*k;
                    if(diff==diff2){
                        count++;
                        break;
                    }
                    else if(diff>diff2){
                        right++;
                    }else{
                        left++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
