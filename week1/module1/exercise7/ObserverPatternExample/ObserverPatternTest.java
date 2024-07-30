package week1.module1.exercise7.ObserverPatternExample;

public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket("ABC Corp", 100.0);

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice(105.0);
        stockMarket.setStockPrice(110.0);

        stockMarket.deregisterObserver(mobileApp);
        stockMarket.setStockPrice(115.0);
    }
}
