package problemSet.insertionSort;

import java.util.Arrays;

public class EmployeeSortID {


    public static void insertionSort(String arr[]){

        int n = arr.length;

        for(int i=1; i<n; i++){
            String key = arr[i];
            int j = i-1;

            while( j >= 0){
                if(key.compareTo(arr[i]) < 0){
                    break;
                }
                arr[j+1] = arr[j] ;
                j--;
            }
            arr[j+1] = key;


        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String args []){

        System.out.println("Employee Id in unsorted manner ->");
        String arr [] = {"A01" , "C03" , "F06" , "D04" , "E05"};
        System.out.println(Arrays.toString(arr));
        System.out.println("Sorting the id using Insertion Sort in Decending Order");
        insertionSort(arr);
    }
}
