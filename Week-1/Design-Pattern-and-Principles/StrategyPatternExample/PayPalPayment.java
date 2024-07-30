public class PayPalPayment implements PaymentStrategy{
    String name;

    public PayPalPayment(String name) {
        this.name = name;
    }

    public void pay(double amount) {
        System.out.println("Successfully paid amount " + amount + " through Pay Pal");
        System.out.println("Name of the sender: " + name);
    }
}
