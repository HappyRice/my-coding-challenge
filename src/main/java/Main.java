import stock.Stock;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Stock apple = new Stock("Apple");
        apple.add(0, 10);
        apple.add(1, 7);
        apple.add(2, 5);
        apple.add(3, 8);
        apple.add(4, 9);
        apple.add(5, 4);
        apple.add(7, 5);

        System.out.println(Arrays.toString(apple.getStockPricesYesterday()));

        System.out.println(apple.getMaxProfit());

    }

}
