package checkforPairWithGivenSum;

import java.util.HashMap;
import java.util.HashSet;

public class PairSum {

    public static  boolean checkpair(int arr[] , int target ){

        HashSet<Integer> set = new HashSet<>();
        boolean found = false;
        for(int num : arr){
            int compliment = target - num;
            if(set.contains(compliment)){
                System.out.println("Pairs are " + compliment + " " + num + " ");
                found = true;
            }
            set.add(num);
        }
        return found;

    }


    public static void main(String[] args) {

        int arr[] = {1,3,5,7,3};
        int target = 8;

        if(checkpair(arr,target)){
            System.out.println("Given Array contains pairs");
        } else{
            System.out.println("Given Array not contains pairs");
        }

    }
}
