package problemstatement2.comparesorting;

import java.util.ArrayList;

public class CompareMergeQuickBubble {

    // Method that tests merge sort
    public static void mergeSortTesting(ArrayList<Integer> numbers, int number) {
        int n = numbers.size();
        double start = System.nanoTime();
        mergeSort(numbers, 0, n - 1);
        double end = System.nanoTime();

        double diff = (end - start) / 1_000_000;
        System.out.println("The time taken by merge sort on " + number + " elements: " + diff + " ms");
        System.out.println("********************************************");
    }

    // Method that tests quick sort
    public static void quickSortTesting(ArrayList<Integer> numbers, int number) {
        int n = numbers.size();
        double start = System.nanoTime();
        quickSort(numbers, 0, n - 1);
        double end = System.nanoTime();

        double diff = (end - start) / 1_000_000;
        System.out.println("The time taken by quick sort on " + number + " elements: " + diff + " ms");
        System.out.println("********************************************");
    }

    // Method that tests bubble sort
    public static void bubbleSortTesting(ArrayList<Integer> numbers, int number) {
        double start = System.nanoTime();
        bubbleSort(numbers);
        double end = System.nanoTime();

        double diff = (end - start) / 1_000_000;
        System.out.println("The time taken by bubble sort on " + number + " elements: " + diff + " ms");
    }

    // Main method
    public static void main(String[] args) {
        int numberHundred = 100;
        int numberThousand = 1000;
        int numberMillion = 100000;

        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = numberHundred; i > 0; i--) {
            list1.add(i);
        }
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = numberThousand; i > 0; i--) {
            list2.add(i);
        }
        ArrayList<Integer> list3 = new ArrayList<>();
        for (int i = numberMillion; i > 0; i--) {
            list3.add(i);
        }

        bubbleSortTesting(new ArrayList<>(list3), numberMillion);
        mergeSortTesting(new ArrayList<>(list3), numberMillion);
        quickSortTesting(new ArrayList<>(list3), numberMillion);

        System.out.println("***************************************");

        bubbleSortTesting(new ArrayList<>(list2), numberThousand);
        mergeSortTesting(new ArrayList<>(list2), numberThousand);
        quickSortTesting(new ArrayList<>(list2), numberThousand);

        System.out.println("***************************************");

        bubbleSortTesting(new ArrayList<>(list1), numberHundred);
        mergeSortTesting(new ArrayList<>(list1), numberHundred);
        quickSortTesting(new ArrayList<>(list1), numberHundred);

        System.out.println("***************************************");
    }

    // Custom bubble sort
    public static void bubbleSort(ArrayList<Integer> arr) {
        int n = arr.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Custom merge sort
    public static void mergeSort(ArrayList<Integer> arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    // Custom merge function
    private static void merge(ArrayList<Integer> arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        ArrayList<Integer> leftArr = new ArrayList<>(n1);
        ArrayList<Integer> rightArr = new ArrayList<>(n2);

        for (int i = 0; i < n1; i++) leftArr.add(arr.get(left + i));
        for (int i = 0; i < n2; i++) rightArr.add(arr.get(mid + 1 + i));

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr.get(i) <= rightArr.get(j)) {
                arr.set(k++, leftArr.get(i++));
            } else {
                arr.set(k++, rightArr.get(j++));
            }
        }
        while (i < n1) arr.set(k++, leftArr.get(i++));
        while (j < n2) arr.set(k++, rightArr.get(j++));
    }

    // Custom quick sort
    public static void quickSort(ArrayList<Integer> arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
   // partition method
    private static int partition(ArrayList<Integer> arr, int low, int high) {
        int pivot = arr.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr.get(j) < pivot) {
                i++;
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        int temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);
        return i + 1;
    }
}
