class Solution {
    public int maxProfit(int[] prices) {
        int mini=prices[0];
        int maxprofit=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<mini){
                mini=prices[i];
            }
            int cost=prices[i]-mini;
            if(cost>maxprofit){
                maxprofit=cost;
            }
        }
        return maxprofit;
    }
}