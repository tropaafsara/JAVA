public class MissingAndRepeatingNumber {
    public static void missingAndRepeatingNumber(int arr[],boolean vis[]) {
        for (int i = 0; i < arr.length; i++) {
            if (!vis[arr[i]]) {
                vis[arr[i]] = true;
            } else {
                System.out.println("Repeating Number = " + arr[i]);
                break;
            }
        }
        for (int i = 1; i < vis.length; i++) {
            if (!vis[i]) {
                System.out.println("Missing Number = " + i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 4 };
        boolean vis[] = new boolean[arr.length];
        missingAndRepeatingNumber(arr, vis);

    }
}
