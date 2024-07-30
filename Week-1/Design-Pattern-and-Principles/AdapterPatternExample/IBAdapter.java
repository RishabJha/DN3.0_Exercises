public class IBAdapter extends UPIgateway {
    InternetBanking banking;

    public IBAdapter(InternetBanking banking) {
        this.banking = banking;
    }

    public void processPayment(double amount) {
        banking.processPayment(amount);
    }
}
