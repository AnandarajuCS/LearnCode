package leetcode;

public class BestTimeToBuyAndSellStock {
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
	}
	public static int maxProfit2(int[] prices) {
		int profit = 0;
		int len = prices.length;
		for(int i =0; i< len;i++)
		{
			for(int j = i;j<len;j++)
			{
				int diff = prices[j] - prices[i] ;
				if(diff > 0)
				{
					if(profit < diff)
					{
						profit = diff;
					}
				}
			}
		}
		return profit;
	}
	public static int maxProfit(int[] prices)
	{
		int minPrice = prices[0];
		int maxProfit = 0;
		for(int i = 1; i<prices.length; i++)
		{
			if(prices[i] < minPrice)
			{
				minPrice = prices[i];
			} else if(maxProfit < (prices[i]-minPrice))
			{
				maxProfit = prices[i]-minPrice;
			}
		}
		return maxProfit;
	}

}
