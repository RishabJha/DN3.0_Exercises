public class LinearSearch {
    public static Product linearSearch(Product[] products, String targetProductName) {
        for(Product product: products) {
            if (product.getProductName().equalsIgnoreCase(targetProductName)) {
                return product;
            }
        }
        return null;
    }
}
