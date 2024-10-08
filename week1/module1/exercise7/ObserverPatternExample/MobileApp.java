package week1.module1.exercise7.ObserverPatternExample;

public class MobileApp implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("MobileApp: Stock " + stockName + " has a new price: " + stockPrice);
    }
}
