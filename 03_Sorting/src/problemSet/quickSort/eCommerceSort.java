package problemSet.quickSort;

import java.util.Arrays;

public class eCommerceSort {

        public static void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                int pi = partition(arr, low, high);
                quickSort(arr, low, pi - 1);
                quickSort(arr, pi + 1, high);
            }
        }

        private static int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (arr[j] < pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;
            return i + 1;
        }

    public static void main(String[] args) {
        System.out.println("E-Commerce Price Products list -> ");
        int price [] = {233,544,33,55,22,455,322};
        System.out.println(Arrays.toString(price));
        quickSort(price , 0 , price.length-1);

        System.out.println("E-Commerce Price Products after the Quick Sort -> ");

        System.out.println(Arrays.toString(price));

    }
}
