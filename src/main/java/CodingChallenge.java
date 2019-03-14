import stock.Stock;

import java.util.Arrays;

public class CodingChallenge {

    public static void main(String[] args) {

        int[] prices = {30, 60, 10, 27, 5, 18, 38, 9, 40, 39, 2, 28, 36};
        // 40 - 5

        try {
            Stock myStock = Stock.createStock("My Stock", prices);

            System.out.println("Stock Name: " + myStock.getName());
            System.out.println("Yesterday's Stock Prices: " + Arrays.toString(myStock.getStockPrices()));
            System.out.println("Max Profit: " + myStock.calculateMaxProfit());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

}
