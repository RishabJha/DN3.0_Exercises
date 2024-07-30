import java.util.Arrays;
import java.util.Comparator;

public class BinarySearch {
    public static Product binarySearch(Product[] products, String targetProductName) {
        Arrays.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getProductName().compareToIgnoreCase(p2.getProductName());
            }
        });
        int start = 0;
        int end = products.length-1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(targetProductName);
            if (comparison == 0) {
                return products[mid];
            } else if(comparison < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return null;
    }
}
