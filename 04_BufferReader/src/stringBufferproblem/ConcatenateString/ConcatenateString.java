package stringBufferproblem.ConcatenateString;

public class ConcatenateString {

    public static void main(String[] args) {
        // Create the string array
        String[] arr = {"Helow" , "World"};
        // Create the string buffer
        StringBuffer sb = new StringBuffer();

        for (String s : arr) {
            sb.append(s);
        }
        System.out.println("Concatenated String is = " + sb);
    }
}
