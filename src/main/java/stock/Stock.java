package stock;

public class Stock {
    private String name;
    private int[] stockPrices;

    public static Stock createStock(String name, int[] stockPrices) {
        // Empty, zero or negative stock prices are rejected as they don't make sense in this context
        validateStockPrices(stockPrices);
        return new Stock(name, stockPrices);
    }

    public String getName() {
        return name;
    }

    public int[] getStockPrices() {
        return stockPrices;
    }

    /** Finds the largest difference between two stock prices with the criteria that the larger price has to
     *  appear after the smaller price in the array. 0 is returned for an empty array or if no profit is possible.
     * */
    public int calculateMaxProfit() {
        int currentMin = stockPrices[0];
        int currentMax = currentMin;

        int maxProfit = 0;

        for (int currentPrice: stockPrices){
            // If new max is found, reset the current max and calculate the difference
            if (currentPrice > currentMax) {
                currentMax = currentPrice;
                int currentProfit = currentMax - currentMin;
                // Compare with the largest profit found so far
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            } else if (currentPrice < currentMin) {
                // If new min is found, reset both the current min and current max
                currentMin = currentPrice;
                currentMax = currentPrice;
            }
        }

        return maxProfit;
    }

    private Stock(String name, int[] stockPrices) {
        this.name = name;
        this.stockPrices = stockPrices;
    }

    private static void validateStockPrices(int[] stockPrices) {
        if (stockPrices.length == 0) {
            throw new IllegalArgumentException("Stock prices must not be empty");
        }
        for (int price: stockPrices) {
            if (price <= 0) {
                throw new IllegalArgumentException("Stock prices must be greater than 0");
            }
        }
    }
}
