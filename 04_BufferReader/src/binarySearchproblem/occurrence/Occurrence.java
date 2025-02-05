package binarySearchproblem.occurrence;


public class Occurrence {


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,5,5,7};


        int left =0;
        int rignt = arr.length-1;
        int target = 4;
        boolean flag = true;
        int count = 0;
        while(left <= rignt){
            int mid = (left + rignt)/2;

            if(arr[mid] == target){
                if(count == 0){
                    System.out.println("Element found");
                    System.out.println("first Ocuurence at the index "+ mid);
                    count ++;
                } else{
                    System.out.println("Element found again");
                    System.out.println("second Ocuurence at the index "+ mid);

                }
                left = mid +1 ;
                flag = false;
            }
            else if(arr[mid] < target){
                left = mid + 1;

            } else{
                rignt = mid -1;
            }
        }

        if(flag){
            System.out.println("Not found");
        }
    }
}
