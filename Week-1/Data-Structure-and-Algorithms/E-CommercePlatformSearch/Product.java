public class Product {
    private int productID;
    private String productName;
    private String category;

    public Product(int productID, String productName, String category) {
        this.productID = productID;
        this.productName = productName;
        this.category = category;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String toString() {
        return "Product ID: " + this.getProductID() + ", Product Name: " + this.getProductName() + ", Category: " + this.getCategory();
    }
}
