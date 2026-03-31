public class BestTimeToBuySellStock {
    public static int maxProfit(int prices[]) {
        // 1. Brute force - O(n^2)
        // int p = Integer.MIN_VALUE;
        // for(int i=0;i<prices.length;i++) {
        //     for(int j=i+1;j<prices.length;j++) {
        //        p = Math.max(p, prices[j] - prices[i]);
        //     }
        // }
        
        // return p;

        // Better sol : 
        // int minPrice = Integer.MAX_VALUE;
        // int maxProfit = 0;

        // for(int i = 0; i < prices.length; i++) {
        //     if(prices[i] < minPrice) {
        //         minPrice = prices[i];
        //     } else {
        //         maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        //     }
        // }
        // return maxProfit;

        // Optimal sol : TC = O(n), SC = O(1)
        int mini = prices[0];
        int maxProfit = 0;
        int n = prices.length;

        for(int i=0;i<n;i++) {
            int cost = prices[i] - mini;
            maxProfit = Math.max(maxProfit, cost);
            mini = Math.min(mini, prices[i]);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int prices[] = {7,1,3,5,6,9};
        System.out.println(maxProfit(prices));
    }    
}
