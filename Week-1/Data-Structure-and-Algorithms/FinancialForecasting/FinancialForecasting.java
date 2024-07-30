import java.util.Scanner;

public class FinancialForecasting {
    public static double calculateFutureValue(double initialValue, double growthRate, int years) {
        if (years == 0) {
            return initialValue;
        }

        return calculateFutureValue(initialValue, growthRate, years-1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter initial value");
        double initialValue = scanner.nextDouble();
        System.out.println("Enter the growth rate: ");
        double growthRate = scanner.nextDouble();
        System.out.println("Enter years: ");
        int years = scanner.nextInt();
        System.out.println("Financial Forecasting of your data is " + calculateFutureValue(initialValue, growthRate, years));
    }
}
