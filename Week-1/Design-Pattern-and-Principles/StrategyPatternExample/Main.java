public class Main {
    public static void main(String[] args) {
        CreditCardPayment creditCardPayment = new CreditCardPayment("Rishab");
        PaymentContext payment = new PaymentContext(creditCardPayment);
        payment.executePayment(1500);

        PayPalPayment payPalPayment = new PayPalPayment("Harsh");
        payment.setPaymentStrategy(payPalPayment);
        payment.executePayment(1700);
    }
}
