import java.util.*;

public class StockSpan {
    // public static void stockSpan(int stocks[], int span[]){
    //     Stack<Integer> s = new Stack<>();
    //     span[0] = 1;
    //     s.push(0);//push index 0 in stack
    //     for(int i=1;i<stocks.length;i++){
    //         int currPrice = stocks[i];
    //         while(!s.isEmpty() && currPrice>stocks[s.peek()]){//index,i = s.peek(), stocks[i]=
    //             s.pop();
    //         }
    //         if(s.isEmpty()){
    //             span[i] = i+1;
    //         }else{
    //                 int prevHigh = s.peek();
    //                 span[i] = i-prevHigh;
    //         }
    //         s.push(i);
    //     }
    // }
    public static int next(int price) {
        Stack<int[]> s=new Stack<>();
        int span=1;
        while(!s.isEmpty() && price>s.peek()[0])
        {
            span+=s.pop()[1];
        }
        
        s.push(new int[]{price, span});
        
        return span;
    }
    public static void main(String[] args) {
        // int stocks[] = {100,80,60,70,60,85,100};
        // int span[] = new int[stocks.length];
        // stockSpan(stocks,span);
        // for(int i=0;i<stocks.length;i++){
        //     System.out.print(span[i]+" ");
        // }

        int price = 
    }
}
