public class Sorting {
    public static void bubbleSort(int n[]) {
        for(int iteration=0; iteration<n.length-1;iteration++){
            for(int j=0;j<=n.length-2-iteration;j++){//n.length-1-i   => last comparison occured here
                if(n[j]>n[j+1]){
                    //swap
                    int temp=n[j];
                    n[j]=n[j+1];
                    n[j+1]=temp;

                }
            }
        }
    }
    public static void selectionSort(int n[]) {
        for(int i=0; i<n.length-1;i++){
            int minPos=i;
            for(int j=i+1; j<n.length;j++){
                if(n[minPos]>n[j]){
                    minPos=j;
                }
            }

            //swap
            int temp =n[minPos];
            n[minPos]=n[i];
            n[i]=temp;
        }
    }
    // public static void insertionSort(int n[]) {
    //     for(int i=0;i<n.length-1;i++){
            
    //         for(int j=i+1;j<n.length;j++){
    //             if(n[i]>n[j]){
    //                 int temp=n[j];
    //                 n[j]=n[i];
    //                 n[i]=temp;
    //             }
    //         }
    //     }
    // }
    public static void insertionSort(int n[]) {
        for(int i=1;i<n.length;i++){
            int curr =n[i];
            int prev = i-1;
            while(prev>=0 && n[prev]>curr){//for descending <
                n[prev+1]=n[prev];
                prev--;
            }
            //insertion
            n[prev+1]=curr;
        }
    }
    public static void printArray(int n[]) {
        for(int i=0;i<n.length;i++){
            System.out.print(n[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int numbers[]={5,4,3,2,1};
        // bubbleSort(numbers);
        // selectionSort(numbers);
        insertionSort(numbers);
        printArray(numbers);
        
    }
}
