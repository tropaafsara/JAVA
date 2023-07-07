public class TrieCreate {
    static class Node{
            Node children[] = new Node[26];
            boolean eow = false;
        public Node(){
            for(int i=0;i<26;i++){
                children[i] = null;
            }
        }
    }
    public static Node root = new Node();
    public static void insert(String words){//O(L) -> Largest word length
        Node curr = root;
        for(int level =0 ;level<words.length(); level++){
            int idx = words.charAt(level)-'a';
            if(curr.children[idx]==null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    public static boolean search(String key){//O(L)
        Node curr = root;
        for(int level =0 ;level<key.length(); level++){
            int idx = key.charAt(level)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }
    public static boolean startsWith(String prefix){//O(L)
        Node curr = root;
        for(int i =0 ;i<prefix.length(); i++){
            int idx = prefix.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }
    public static void main(String[] args) {
        // String words[] = {"the", "a", "there", "their","any","thee"};
        String words[] = {"apple", "app", "mango", "man","woman"};
        for(int i=0; i<words.length;i++){
            insert(words[i]);
        }
        // System.out.println(search("thor"));
        // System.out.println(search("thee"));

        String prefix1 = "app";//true
        String prefix2 = "moon";//false
        System.out.println(startsWith(prefix1));
        System.out.println(startsWith(prefix2));
    }
}
