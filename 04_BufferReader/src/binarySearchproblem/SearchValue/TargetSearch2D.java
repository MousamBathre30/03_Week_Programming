package binarySearchproblem.SearchValue;

public class TargetSearch2D {


    public static void main(String[] args) {
        int[][] arr = {
                       {1,2,3},
                       {4,5,6},
                       {7,8,9}
                      };
        int left =0;
        int rignt = 3 * 3 -1;
        int target = 5;
        boolean flag = true;
        while(left <= rignt){
            int mid = (left + rignt)/2;
            int row = mid/3;
            int col = mid % 3;
            if(arr[row][col] == target){
                System.out.println("Element found");
                flag = false;
                break;
            }
            else if(arr[row][col] < target){
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
