import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Order[] orders1 = {
                new Order("O101", "Rishab", 450),
                new Order("O102", "Harsh", 350),
                new Order("O103", "David", 250),
                new Order("O104", "Alan", 150)
        };
        BubbleSort.bubbleSort(orders1);
        printOrders(orders1);

        System.out.println();

        Order[] orders2 = {
                new Order("O105", "Alice", 450),
                new Order("O106", "Bob", 350),
                new Order("O107", "Charlie", 250),
                new Order("O108", "John", 150)
        };
        QuickSort.quickSort(orders2);
        printOrders(orders2);

    }

    public static void printOrders(Order[] orders) {
        for (Order order: orders) {
            System.out.println(order);
        }
    }
}
