package StringBuilderproblem.removeDuplicate;

import java.util.HashSet;

public class RemoveDuplicate {

    public static void main(String[] args) {

        // Initialize an empty StringBuilder and a HashSet to KeepTrace

        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        // String containing Basic string
        String str = "HelloWorld";
        // using append method
        for(int i=0; i<str.length(); i++){
            if(!set.contains(str.charAt(i))){
                sb.append(str.charAt(i));
            }
            set.add(str.charAt(i));
        }

        System.out.println("String Builder Contains = " + sb);
    }
}
