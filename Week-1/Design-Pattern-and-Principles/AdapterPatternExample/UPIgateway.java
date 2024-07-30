public class UPIgateway implements PaymentProcessor {

    public void processPayment(double amount) {
        System.out.println("Payment processed of amount " + amount + " through UPI");
    }
}