package week1.module1.exercise1.SingletonPatternExample;

public class SingletonTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("logger1 and logger2 are different instances.");
        }

        logger1.log("This is a test message.");
        logger2.log("Logging from logger2.");
    }
}
