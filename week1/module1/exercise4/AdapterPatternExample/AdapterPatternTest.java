package week1.module1.exercise4.AdapterPatternExample;

public class AdapterPatternTest {
    public static void main(String[] args) {
        PayPalPaymentGateway payPalGateway = new PayPalPaymentGateway();
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalGateway);
        payPalProcessor.processPayment(100.0);

        StripePaymentGateway stripeGateway = new StripePaymentGateway();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);
        stripeProcessor.processPayment(200.0);
    }
}
