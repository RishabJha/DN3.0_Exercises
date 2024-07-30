public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(124, "Apple", 50, 145.56);
        Product product2 = new Product(455, "Mango", 35, 105.46);

        Inventory inventory = new Inventory();
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.printInventory();
        System.out.println();

        Product product = new Product(124, "Apple", 45, 130);
        inventory.updateProduct(124, product);
        inventory.printInventory();
        System.out.println();

        inventory.deleteProduct(455);
        inventory.printInventory();

    }
}
