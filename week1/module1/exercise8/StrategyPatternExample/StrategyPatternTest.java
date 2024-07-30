package week1.module1.exercise8.StrategyPatternExample;

public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "John Doe");
        PaymentStrategy paypalPayment = new PayPalPayment("john.doe@example.com");

        PaymentContext context = new PaymentContext(creditCardPayment);
        context.executePayment(150.0);

        context = new PaymentContext(paypalPayment);
        context.executePayment(200.0);
    }
}
