import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class P {
    public static int maxProfit(int[] a, int[] b, int n)
    {
 
        // Max profit will be saved here
        int maxP = -1;
 
        // loop to check all possible combinations of sales
        for (int i = 0; i < n + 1; i++) {
 
            // the sum of the profit after the sale
            // for products 0 to i in market A
            int sumA = 0;
 
            for (int j = 0; j < Math.min(i, a.length); j++)
                sumA += a[j];
 
            // the sum of the profit after the sale
            // for products i to n in market B
            int sumB = 0;
            for (int j = i; j < b.length; j++)
                sumB += b[j];
 
            // Replace the value of Max Profit with a
            // bigger value among maxP and sumA+sumB
            maxP = Math.max(maxP, sumA + sumB);
        }
 
        // Return the value of Max Profit
        return maxP;
    }
    public static void main(String[] args) {
        int[] a = { 3,1,2,3 };
        // int[] a = { 2, 3, 2 };
        // int[] b = { 10, 30, 40 };
        int[] b = { 2,1,4,4};
        System.out.println(maxProfit(a, b, 4));
    }

}