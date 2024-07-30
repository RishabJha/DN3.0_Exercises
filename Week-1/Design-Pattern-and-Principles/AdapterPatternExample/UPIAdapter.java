public class UPIAdapter extends InternetBanking {
    UPIgateway upi;

    public UPIAdapter(UPIgateway upi) {
        this.upi = upi;
    }

    public void processPayment(double amount) {
        upi.processPayment(amount);
    }
}
