package week1.module2.exercise7;


public class FinancialForecasting {

    public static double calculateFutureValueRecursive(double base, int exponent) {
        if (exponent == 0) {
            return 1.0;
        }
        return base * calculateFutureValueRecursive(base, exponent - 1);
    }

    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        double base = 1 + growthRate;
        double futureValueFactor = calculateFutureValueRecursive(base, periods);
        return presentValue * futureValueFactor;
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;  
        double growthRate = 0.05;      
        int periods = 10;          

        double futureValue = calculateFutureValue(presentValue, growthRate, periods);
        System.out.println("Future Value: $" + futureValue);
    }
}
