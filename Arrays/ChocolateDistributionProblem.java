import java.util.Arrays;

public class ChocolateDistributionProblem {
    public static long chocolate(int[] arr, int m) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        int i = 0;
        int j = i + (m-1);
        while (j < arr.length) {
            int min = arr[i];
            int max = arr[j];
            int minDiff2 = max - min;
            i++;
            j++;
            minDiff = Math.min( minDiff2, minDiff);
        }
        return (long)minDiff;

    }   

    public static void main(String[] args) {
        int [] arr = { 3, 4, 1, 9, 56, 7, 9, 12 };
        int m = 5;
        System.out.println(chocolate(arr, m));
    }
}
