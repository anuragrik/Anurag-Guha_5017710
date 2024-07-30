package week1.module1.exercise4.AdapterPatternExample;

public class StripeAdapter implements PaymentProcessor {
    private StripePaymentGateway stripePaymentGateway;

    public StripeAdapter(StripePaymentGateway stripePaymentGateway) {
        this.stripePaymentGateway = stripePaymentGateway;
    }

    @Override
    public void processPayment(double amount) {
        stripePaymentGateway.charge(amount);
    }
}
