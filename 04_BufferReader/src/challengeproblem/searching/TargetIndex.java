package challengeproblem.searching;

import java.util.Arrays;

public class TargetIndex {

    public static void main(String[] args) {
        int[] array  = {1,3,4,5,2,4,6,2};
        Arrays.sort(array);
        int target = 4;
        int left = 0;
        int right = array.length;
        while(left <= right){

            int mid = (left+right)/2;
            if(array[mid] == target){

                System.out.println("Element found");
                break;
            } else if (array[mid] < target){
                left = mid;
            } else{
                right = mid;
            }
        }
    }
}
