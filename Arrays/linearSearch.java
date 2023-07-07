public class linearSearch {

    /* public static int linearSearch(int numbers[], int key){
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==key){
                return i;
            }
        }
        return -1;
    } */
    public static int linearSearch1(String words[], String keys){
        for(int i=0;i<words.length;i++){
            if(words[i]==keys){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        
        String words[] = {"alu porota", "strawberry", "blueberry", "moja moja"};
        String keys = "moja moja";
        int index2 = linearSearch1(words, keys);
        System.out.println(keys + " is present at "+index2);
        if(index2==-1){
            System.out.println(keys+ " not found in array");
        }




        /* int numbers [] = {2,4,6,2,56,4,2,10};
        int key = 10;
        int index  = linearSearch(numbers, key);
        System.out.println("key is present at "+index+" index");
        if(index==-1){
            System.out.println("Key si not found");
        } */
    }
    
}
