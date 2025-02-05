package StringBuilderproblem.reverseString;

public class ReverseString {

    public static void main(String[] args) {

        // Create a new StringBuilder object
        StringBuilder sb = new StringBuilder();

        // append the string in the StringBuilder

        sb.append("Hello");

        // reverse the String using reverse() method

        sb.reverse();

        // Convert the String Builder back to a String

        System.out.println("String Contains = " + sb.toString());

    }

}

