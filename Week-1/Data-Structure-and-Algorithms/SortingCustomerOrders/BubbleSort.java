public class BubbleSort {
    public static void bubbleSort(Order[] arr) {
        boolean swapped = false;
        for (int i = 0; i < arr.length; i++) {
            for(int j = 1; j < arr.length - i; j++) {
                if (arr[j].getTotalPrice() < arr[j-1].getTotalPrice()) {
                    swap(arr, j, j-1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    private static void swap(Order[] arr, int a, int b) {
        Order temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
