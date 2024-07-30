public class CreditCardPayment implements PaymentStrategy{
    String name;

    public CreditCardPayment(String name) {
        this.name = name;
    }
    public void pay(double amount) {
        System.out.println("Successfully paid amount " + amount + " through Credit Card");
        System.out.println("Name of the sender: " + name);
    }
}
