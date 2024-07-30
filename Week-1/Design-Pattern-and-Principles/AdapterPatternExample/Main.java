public class Main {
    public static void main(String[] args) {
        InternetBanking banking = new InternetBanking();
        banking.processPayment(1500.123);

        UPIgateway upi = new UPIgateway();
        upi.processPayment(123.4);

        UPIgateway upigate = new IBAdapter(banking);
        upigate.processPayment(12345.6);

        InternetBanking ib = new UPIAdapter(upi);
        ib.processPayment(1800.6);
    }
}
