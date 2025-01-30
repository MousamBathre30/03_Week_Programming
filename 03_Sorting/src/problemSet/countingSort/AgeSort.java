package problemSet.countingSort;

import java.util.Arrays;

public class AgeSort {

    public static void countingSort(int arr[]){

        int n = arr.length;

        int M = 0;

        // count the max
        for(int i=0; i<n; i++){
            M = Math.max(M,arr[i]);

        }
        int countArray [] = new int[M+1];

        // find the frequency
        for(int i = 0 ; i< n; i++){
            countArray[arr[i]]++;
        }

        for(int i=1; i<=M; i++){
            countArray [i] += countArray[i-1];

        }

        int answer [] = new int [n];
        for(int i=n-1; i>=0; i--){
            answer[countArray[arr[i]] - 1] = arr[i];
            countArray[arr[i]]--;
        }
        for(int i=0; i<n; i++){
            arr[i] = answer[i];
        }
    }


    public static void main(String[] args) {
        int age [] = {12 ,17 , 16 , 15 ,14,};

        System.out.println("Student age ");
        System.out.println(Arrays.toString(age));

        System.out.println("Student age after the counting sort");

        countingSort(age);

        System.out.println(Arrays.toString(age));
    }
}
