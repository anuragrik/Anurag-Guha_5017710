package week1.module1.exercise4.AdapterPatternExample;

public class PayPalPaymentGateway {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal.");
    }
}
