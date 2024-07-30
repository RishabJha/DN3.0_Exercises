public class Main {
    public static void main(String[] args) {
        StockMarket stock = new StockMarket();
        Observer mobileApp1 = new MobileApp("Mobile App 1 ");
        Observer mobileApp2 = new MobileApp("Mobile App 2 ");
        Observer webApp = new WebApp("Web App ");

        stock.registerObserver(mobileApp1);
        stock.registerObserver(mobileApp2);
        stock.registerObserver(webApp);

        stock.setStockPrice(100.50);
    }
}
