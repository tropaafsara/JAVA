public class practice {
    public static void update(int marks[]) {
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 1;
        }
    }

    public static int linearSearch(String words[], String key) {
        for (int i = 0; i < words.length; i++) {
            if (words[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int findLargest(int num[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {
            if (largest < num[i]) {
                largest = num[i];
            }
        }
        return largest;
    }

    public static int binarySearch(int numbers[],int key){
        int start=0;
        int end = numbers.length-1;
        
        while(start<=end){
            int mid=(start+end)/2;
            if(key==numbers[mid]){
                return mid;
            }
            if(numbers[mid]>key){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }

    public static void reverseArray(int arr[]){
        int first =0;
        int last = arr.length-1;
        
        while(first<last){
            int temp = arr[last];
            arr[last]= arr[first];
            arr[first] = temp;
            first++;
            last--;
            
        }
    }

    public static void pairsInArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                System.out.print(arr[i]+","+arr[j]+ " ");
            }
            System.out.println();
        }
    }

    public static void subArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.print(", ");
            }
            System.out.println();
        }
    }
    //brute force
    public static void subArraySum(int arr[]){
        int sum=0;
        int largest = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                
                for(int k=i;k<=j;k++){
                    
                    // System.out.print(arr[k]+" ");
                    sum+=arr[k];
                }
                if(largest<sum){
                    largest=sum;
                }
                sum = 0;
                // System.out.print(", ");
            }
            // System.out.println();
        }
        System.out.println(largest);
    }
    //prefix sum
    public static int subArraySum1(int nums[]){
        int sum=0;
        int largest = Integer.MIN_VALUE;
        // int prefix[] = new int[nums.length];
        int[] prefix =  new int [ nums.length ];

        prefix[0] =nums[0];
        for(int i=1;i<prefix.length;i++){
            prefix[i] = prefix[i-1]+nums[i];
        }
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){               
                sum = i== 0 ? prefix[j] : prefix[j] - prefix[i-1];
                if(largest<sum){
                    largest=sum;
                }               
            }       
        }
        return largest;
    }
    //Kadane's Algo

    public static void main(String[] args) {
        // int marks[] = {97,98,99};
        // update(marks);

        // //print
        // for(int i=0;i<marks.length;i++){
        // System.out.println(marks[i]);
        // }

        // String words[] = {"alu porota", "strawberry", "blueberry", "moja moja"};
        // String key = "moja moja1";
        // System.out.println(linearSearch(words, key));

        // int num[] ={2,3,4,7,9,1,10,60};
        // System.out.println(findLargest(num));

        // int numbers[]= {2,4,6,8,10,12,14,18};
        // int key = 10;
        // System.out.println(binarySearch(numbers, key));

        // int arr[]={2,4,6,2,8,10,11};
        // reverseArray(arr);
        // for(int i=0;i<arr.length;i++){
        //     System.out.print(arr[i]+" ");
        // }

        int arr[]={5,4,-1,7,8};
        // pairsInArray(arr);
        //print array
        // subArray(arr);
        System.out.println(subArraySum1(arr));


    }
}
