package week1.module1.exercise4.AdapterPatternExample;

public class StripePaymentGateway {
    public void charge(double amount) {
        System.out.println("Charging $" + amount + " through Stripe.");
    }
}
