public class BuySellStock {
    // public static int maxProfit(int[] prices) {
    //     //brute force
    //     int maxProfit = 0;
    //     int buyPrice = Integer.MAX_VALUE;
    //     for (int i = 0; i < prices.length - 1; i++) {
    //         int buyPrice1 = prices[i];
    //         buyPrice = Math.min(buyPrice, buyPrice1);
    //         int sellPrice = prices[i + 1];
    //         int profit = sellPrice - buyPrice;
    //         maxProfit = Math.max(maxProfit, profit);
    //     }
    //     return maxProfit;
    // }
    public static int maxProfit(int[] prices) {
        //brute force
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length ; i++) {
            if(buyPrice < prices[i]){//profit
                int profit = prices[i] - buyPrice;//today's profit
                maxProfit = Math.max(maxProfit, profit);
            }else{
                buyPrice=prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
    }
}
