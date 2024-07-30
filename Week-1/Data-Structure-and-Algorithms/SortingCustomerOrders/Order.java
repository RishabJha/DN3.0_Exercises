public class Order {
    private String orderID;
    private String customerName;
    private int totalPrice;

    public String getOrderID() {
        return orderID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public Order(String orderID, String customerName, int totalPrice) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
