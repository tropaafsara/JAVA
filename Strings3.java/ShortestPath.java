public class ShortestPath {
    public static int shortestPath(String s){
        int n = s.length();
        int x=0;
        int y=0;
        int res;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='W'){
                x--;
            }
            if(s.charAt(i)=='E'){
                x++;
            }
            if(s.charAt(i)=='N'){
                y++;
            }
            if(s.charAt(i)=='S'){
                y--;
            }
        }
        return res = (int) Math.sqrt((x*x)+(y*y));
    }
    public static void main(String[] args) {
        String s = "WNEENESENNN";
        System.out.println(shortestPath(s));
    }
}
