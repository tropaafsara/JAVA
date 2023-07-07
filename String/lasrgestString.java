public class lasrgestString {
    public static void main(String[] args) {
        //lexicographic comparison (character-wise comparison. Ex- b is smaller than c)
        // str1.compareTo(str2){
        //     0 : equals
        //     - ve : str1<str2
        //     + ve : str1>str2
        // 

        String fruits[] = {"apple", "mango", "banana"}; // m largest lexicographically
        String largest= fruits[0];
        for(int i=1;i<fruits.length;i++){
            if(largest.compareTo(fruits[i])<0){
                largest=fruits[i];
            }
        }
        System.out.println(largest);


    }
}
