package binarySearchproblem.rotationarray;

import java.sql.SQLOutput;

public class RotationArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int n = array.length;
        int low = 0;
        int high = n - 1;

        int target = 1;
        while (low <= high) {
            int mid = (low+high)/2;
            if(array[low] == array[high]){
                System.out.println("The Rotation Element is find " + array[low] + "  index is " + mid);
                return;
            } else if(array[mid] < array[high]){
                high = mid;
            } else{
               {
                    low = mid + 1;
                }
            }

        }
    }
}
