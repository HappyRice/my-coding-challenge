package stock;

public class Stock {
    private String name;
    private int[] stockPrices;

    public static Stock createStock(String name, int[] stockPrices) {
        validateStockPrices(stockPrices);
        return new Stock(name, stockPrices);
    }

    public String getName() {
        return name;
    }

    public int[] getStockPrices() {
        return stockPrices;
    }

    public int getMaxProfit() {
        if (isStockPricesEmpty()) {
            return 0;
        }

        int currentMin = stockPrices[0];
        int currentMax = currentMin;
        int maxProfit = 0;

        for (int currentPrice: stockPrices){
            if (currentPrice > 0) {
                if (currentPrice > currentMax) {
                    currentMax = currentPrice;
                    int currentProfit = currentMax - currentMin;
                    if (currentProfit > maxProfit) {
                        maxProfit = currentProfit;
                    }
                } else if (currentPrice < currentMin) {
                    currentMin = currentPrice;
                    currentMax = currentMin;
                }
            }
        }

        return maxProfit;
    }

    private Stock(String name, int[] stockPrices) {
        this.name = name;
        this.stockPrices = stockPrices;
    }

    private static void validateStockPrices(int[] stockPrices) {
        for (int price: stockPrices) {
            if (price <= 0) {
                throw new IllegalArgumentException("Stock prices must be greater than 0");
            }
        }
    }

    private boolean isStockPricesEmpty() {
        return stockPrices.length == 0;
    }
}
