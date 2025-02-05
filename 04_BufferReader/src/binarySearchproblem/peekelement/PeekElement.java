package binarySearchproblem.peekelement;

public class PeekElement {


    public static void main(String[] args) {
        int[] arrays = {1,4,3,6,8,3};

        int left = 0;
        int right = arrays.length;
        while(left <= right){
            int mid = (left + right)/2;

            if(arrays[mid] > arrays [mid -1] && arrays[mid] > arrays[mid+1] ){
                System.out.println("The peak is " + arrays[mid]);
                return;
            }
            else if(arrays[mid] < arrays[mid-1]){
                right = mid-1;
            } else if(arrays[mid] < arrays[mid+1]){
                left = mid + 1;
            } else{
                right = mid;
            }
        }
    }
}
