package twoSumProblem;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {


    public static boolean getTarget(int arr [] , int target){
       HashSet<Integer> set = new HashSet<>();
       int curr_sum =0 ;
       for(int i=0; i<arr.length; i++){
            curr_sum = arr[i];
            int commulative = target - curr_sum;
            if(set.contains(commulative)){
                return true;
            }
            set.add(commulative);
       }
       return false;
    }
    public static void main(String[] args) {
        int arr [] = {2,3,3,2,2};
        int target = 8;

        boolean ans = getTarget(arr,target);
        if(ans){
            System.out.println("Target Found");
        } else{
            System.out.println("Target Not Present");
        }
    }
}
