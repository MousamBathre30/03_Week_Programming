package problemSet.heapSort;

import java.util.Arrays;

public class SalaryDemand {
    public static void heapify(int arr[] , int n , int i ){

        int largest_as_Root = i ;

        int leftIndex = 2 * i + 1 ;
        int rightIndex = 2 * i + 2 ;

        if(leftIndex < n && arr[leftIndex] > arr[largest_as_Root]){
            largest_as_Root = leftIndex;
        }

        if(rightIndex < n && arr[rightIndex] > arr[largest_as_Root]){
            largest_as_Root = rightIndex;

        }

        if(largest_as_Root != i){
            int temp = arr[i] ;
            arr[i] = arr [largest_as_Root];
            arr[largest_as_Root] = temp ;
            heapify(arr,n,largest_as_Root);
        }
    }
    public static void heapSort(int arr[]){
        int n = arr.length;
        // Build heap

        for(int i=n/2 -1 ; i>= 0 ; i--){
            heapify(arr,n,i);
        }
        for(int i = n-1; i > 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr,i,0);
        }
    }

    public static void main(String[] args) {
        int score [] = {233,45,223,434,232,266,377,374};
        System.out.println("Salary demand of the Candidate -> ");

        System.out.println(Arrays.toString(score));

        System.out.println("Demanod after the heap sort -> ");
        heapSort(score);
        System.out.println(Arrays.toString(score));
    }
}
