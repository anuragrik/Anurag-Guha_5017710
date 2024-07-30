package week1.module1.exercise4.AdapterPatternExample;

public class PayPalAdapter implements PaymentProcessor {
    private PayPalPaymentGateway payPalPaymentGateway;

    public PayPalAdapter(PayPalPaymentGateway payPalPaymentGateway) {
        this.payPalPaymentGateway = payPalPaymentGateway;
    }

    @Override
    public void processPayment(double amount) {
        payPalPaymentGateway.makePayment(amount);
    }
}