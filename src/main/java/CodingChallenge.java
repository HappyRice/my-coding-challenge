import stock.Stock;

import java.util.Arrays;

public class CodingChallenge {

    public static void main(String[] args) {

        int[] prices = {6, 10, 7, 5, 8, 9, 1};

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
