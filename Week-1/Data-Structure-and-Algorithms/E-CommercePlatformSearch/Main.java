public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Smartphone", "Electronics"),
                new Product(103, "Coffee Maker", "Home Appliances"),
                new Product(104, "Desk Chair", "Furniture"),
                new Product(105, "Book", "Books")
        };

        Product linearSearch = LinearSearch.linearSearch(products, "laptop");
        if (linearSearch != null) {
            System.out.println("Result of linear search is: " + linearSearch);
        } else {
            System.out.println("Product not found");
        }

        Product binarySearch = BinarySearch.binarySearch(products, "book");
        if (binarySearch != null) {
            System.out.println("Result of binary search is: " + binarySearch);
        } else {
            System.out.println("Product not found");
        }
    }
}
