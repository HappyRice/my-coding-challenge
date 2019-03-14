package stock;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StockTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testSinglePrice() {
        final int[] stockPrices = {10};
        final Stock test = Stock.createStock("Test", stockPrices);

        Assert.assertEquals(0, test.calculateMaxProfit());
    }

    @Test
    public void testDuplicatePrices() {
        final int[] stockPrices = {10, 10, 10, 10, 10};
        final Stock test = Stock.createStock("Test", stockPrices);

        Assert.assertEquals(0, test.calculateMaxProfit());
    }

    @Test
    public void testDecreasingOnlyPrices() {
        final int[] stockPrices = {10, 8, 7, 5, 3, 1};
        final Stock test = Stock.createStock("Test", stockPrices);

        Assert.assertEquals(0, test.calculateMaxProfit());
    }

    @Test
    public void testIncreasingOnlyPrices() {
        final int[] stockPrices = {1, 3, 5, 7, 8, 10};
        final Stock test = Stock.createStock("Test", stockPrices);

        // 10 - 1
        Assert.assertEquals(9, test.calculateMaxProfit());
    }

    @Test
    public void testCorrectMaxProfitIsReturned1() {
        final int[] stockPrices = {10, 7, 5, 8, 9, 15};
        final Stock test = Stock.createStock("Test", stockPrices);

        // 15 - 5
        Assert.assertEquals(10, test.calculateMaxProfit());
    }

    @Test
    public void testCorrectMaxProfitIsReturned2() {
        final int[] stockPrices = {5, 7, 10, 2, 9, 4};
        final Stock test = Stock.createStock("Test", stockPrices);

        // 9 - 2
        Assert.assertEquals(7, test.calculateMaxProfit());
    }

    @Test
    public void testCorrectMaxProfitIsReturned3() {
        final int[] stockPrices = {5, 7, 3, 9, 4, 8};
        final Stock test = Stock.createStock("Test", stockPrices);

        // 9 - 3
        Assert.assertEquals(6, test.calculateMaxProfit());
    }

    @Test
    public void testEmptyStockPricesAreInvalid() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Stock prices must not be empty");

        final int[] stockPrices = {};
        Stock.createStock("Test", stockPrices);
    }

    @Test
    public void testNegativeStockPricesAreInvalid() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Stock prices must be greater than 0");

        final int[] stockPrices = {-5, 7, -3, 9, 4, 8};
        Stock.createStock("Test", stockPrices);
    }

    @Test
    public void testZeroStockPricesAreInvalid() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Stock prices must be greater than 0");

        final int[] stockPrices = {0, 7, 1, 9, 4, 8};
        Stock.createStock("Test", stockPrices);
    }

}
