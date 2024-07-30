public class QuickSort {
    public static void quickSort(Order[] arr) {
        helperQuickSort(arr, 0, arr.length - 1);
    }

    private static void helperQuickSort(Order[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;
        int pivot = arr[mid].getTotalPrice();
        while (start <= end) {
            while (arr[start].getTotalPrice() < pivot) {
                start++;
            }

            while (arr[end].getTotalPrice() > pivot) {
                end--;
            }

            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        helperQuickSort(arr, low, end);
        helperQuickSort(arr, start, high);
    }

    private static void swap(Order[] arr, int a, int b) {
        Order temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
