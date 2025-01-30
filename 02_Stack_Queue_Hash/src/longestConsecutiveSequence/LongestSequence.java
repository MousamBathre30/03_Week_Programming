package longestConsecutiveSequence;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LongestSequence {

    public static void getSequence(int arr[]){
        HashMap<Integer , Integer> map = new LinkedHashMap<>();
        int count = 1;
        for(int i=1; i<arr.length ; i++){
            if(arr[i] == arr[i-1]){
                count++;
            }  else{
                map.put(arr[i-1] , count);
                count = 1;
            }
        }
        map.put(arr[arr.length - 1] , count);


        System.out.println("Consecutive Element Frequencies:");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("MAX");

        int key = -1;
        int max = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
                key = entry.getKey();
            }
        }

        System.out.println("KEy is  " + key + " " + "Value is " +max);


    }
    public static void main(String[] args) {

        int arr [] = {1,2,2,2,3,4,4,};

        getSequence(arr);
    }
}
