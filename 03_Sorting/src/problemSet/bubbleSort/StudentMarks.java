package problemSet.bubbleSort;

import java.util.Arrays;

public class StudentMarks {

    public static void bubbleSort(int arr[]){
        //
        int n = arr.length;
        boolean swapped;
        for(int i=0; i<n-1; i++){
            swapped = false;
            for(int j=0; j<n-i-1; j++){
                // swap the array
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }

            }
            if(!swapped){
                break;
            }
        }
    }

        public static void printarray(int arr []){
            System.out.println(Arrays.toString(arr));
            System.out.println();
        }

    public static void main(String[] args) {
        System.out.println("The students marks array is ");
        int arr[] = {89 , 34 , 45 , 22 , 44 ,90 , 33 , 99};
        printarray(arr);
        bubbleSort(arr);
        System.out.println("After sort the student marks using bubble sort");
        printarray(arr);
    }
}
