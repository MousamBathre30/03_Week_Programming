package problemSet.selectionSort;

import java.util.Arrays;

public class ExamScoreSort {

    public static void selectionSort(int arr[]){


        for(int i=0; i<arr.length-1; i++){
            int min_indx = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] <arr[min_indx]){
                    min_indx = j;
                }
            }

            // swap variable

            int temp = arr[i];
            arr[i] = arr[min_indx];
            arr[min_indx] = temp ;
        }

    }

    public static void main(String[] args) {
        int score [] = {233,45,223,434,232,266,377,374};
        System.out.println("Score of the Student -> ");

        System.out.println(Arrays.toString(score));

        System.out.println("Score after the selction sort -> ");
        selectionSort(score);
        System.out.println(Arrays.toString(score));
    }
}
