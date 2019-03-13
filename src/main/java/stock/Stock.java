package stock;

public class Stock {
    private final static int MAX_TIME_SLOTS = 421; // Assumption that the market starts trading at 10am and ends at 5pm

    private String name;
    private int[] stockPricesYesterday;

    public Stock(String name, int[] stockPricesYesterday) {
        this.name = name;
        // Validate that the input array is 421 elements
        this.stockPricesYesterday = stockPricesYesterday;
    }

    public Stock(String name) {
        this.name = name;
        this.stockPricesYesterday = new int[MAX_TIME_SLOTS];
    }

    public String getName() {
        return name;
    }

    public int[] getStockPricesYesterday() {
        return stockPricesYesterday;
    }

    public boolean add(int index, int stockPrice) {
        if (index >= 0 && index < MAX_TIME_SLOTS) {
            stockPricesYesterday[index] = stockPrice;
            return true;
        }
        return false;
    }

    public int getMaxProfit() {
        if (stockPricesYesterday.length == 0) {
            return 0;
        }

        int maxDiff = 0;
        int localMin = stockPricesYesterday[0];
        int localMax = localMin;

        for (int stockPrice: stockPricesYesterday){
            if (stockPrice > localMax) {
                localMax = stockPrice;
                int localDiff = localMax - localMin;
                if (localDiff > maxDiff) {
                    maxDiff = localDiff;
                }
            } else if (stockPrice < localMin) {
                localMin = stockPrice;
                localMax = localMin;
            }
        }

        return maxDiff;
    }
}
