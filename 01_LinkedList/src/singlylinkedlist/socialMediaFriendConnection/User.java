package singlylinkedlist.socialMediaFriendConnection;
import java.util.*;
class User {
    int userID;
    String name;
    int age;
    List<Integer> friends;  // List of Friend IDs
    User next;

    public User(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }
}
