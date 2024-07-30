import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> list;

    public Inventory() {
        list = new ArrayList<>();
    }

    public void addProduct(Product product) {
        list.add(product);
    }

    public void updateProduct(int productID, Product product) {
        boolean found = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(0).getProductID() == productID) {
                list.set(i, product);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found");
        }
    }

    public void deleteProduct(int productID) {
        boolean found = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductID() == productID) {
                list.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found");
        }
    }

    public void printInventory() {
        for(Product product: list) {
            System.out.println(product.toString());
        }
    }
}
