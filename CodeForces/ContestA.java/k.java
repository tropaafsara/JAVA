import java.util.Scanner;
import java.util.Stack;

public class k {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt(); // Number of test cases
        
        while (t-- > 0) {
            int n = input.nextInt(); // Number of books in each stack
            int x = input.nextInt(); // Tenzing's favorite number
            
            // Reading difficulty ratings of books in each stack
            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            Stack<Integer> stack3 = new Stack<>();
            
            for (int i = 0; i < n; i++)
                stack1.push(input.nextInt());
            
            for (int i = 0; i < n; i++)
                stack2.push(input.nextInt());
            
            for (int i = 0; i < n; i++)
                stack3.push(input.nextInt());
            
            // Check if Tenzing can reach the favorite number
            boolean possible = isFavoriteNumberPossible(n, x, stack1, stack2, stack3);
            
            // Output the result
            if (possible)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
        
        input.close();
    }
    
    // Helper method to check if Tenzing can reach the favorite number
    private static boolean isFavoriteNumberPossible(int n, int x, Stack<Integer> stack1, Stack<Integer> stack2, Stack<Integer> stack3) {
        int maxRating = 0;
        
        // Find the maximum difficulty rating among all stacks
        while (!stack1.isEmpty() || !stack2.isEmpty() || !stack3.isEmpty()) {
            int top1 = stack1.isEmpty() ? 0 : stack1.peek();
            int top2 = stack2.isEmpty() ? 0 : stack2.peek();
            int top3 = stack3.isEmpty() ? 0 : stack3.peek();
            
            maxRating = Math.max(maxRating, Math.max(top1, Math.max(top2, top3)));
            
            if (!stack1.isEmpty())
                stack1.pop();
            
            if (!stack2.isEmpty())
                stack2.pop();
            
            if (!stack3.isEmpty())
                stack3.pop();
        }
        
        // Check if the maximum rating is greater than x or (maxRating XOR x) is already present in the stacks
        if (maxRating > x || ((maxRating ^ x) & x) != 0)
            return false;
        
        return true;
    }
}
