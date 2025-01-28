package singlylinkedlist.socialMediaFriendConnection;
import java.util.*;
class SocialMediaSystem {
    private User head;

    public SocialMediaSystem() {
        head = null;
    }

    // Add a user to the system
    public void addUser(int userID, String name, int age) {
        User newUser = new User(userID, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    // Add a friend connection between two users
    public void addFriend(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);

        if (user1 != null && user2 != null && userID1 != userID2) {
            // Add each other to the other's friend list
            if (!user1.friends.contains(userID2)) {
                user1.friends.add(userID2);
            }
            if (!user2.friends.contains(userID1)) {
                user2.friends.add(userID1);
            }
            System.out.println("Friend connection established between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("Invalid user IDs or they are the same.");
        }
    }

    // Remove a friend connection between two users
    public void removeFriend(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);

        if (user1 != null && user2 != null) {
            // Remove each other from each other's friend list
            user1.friends.remove(Integer.valueOf(userID2));
            user2.friends.remove(Integer.valueOf(userID1));
            System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);

        if (user1 != null && user2 != null) {
            List<Integer> mutualFriends = new ArrayList<>(user1.friends);
            mutualFriends.retainAll(user2.friends);

            if (mutualFriends.isEmpty()) {
                System.out.println("No mutual friends found between " + user1.name + " and " + user2.name);
            } else {
                System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ": " + mutualFriends);
            }
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Display all friends of a specific user
    public void displayFriends(int userID) {
        User user = findUserByID(userID);

        if (user != null) {
            System.out.println(user.name + "'s friends: " + user.friends);
        } else {
            System.out.println("User not found.");
        }
    }

    // Search for a user by Name
    public void searchUserByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("User found: " + temp.name + ", ID: " + temp.userID + ", Age: " + temp.age);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User with name " + name + " not found.");
    }

    // Search for a user by User ID
    public User findUserByID(int userID) {
        User temp = head;
        while (temp != null) {
            if (temp.userID == userID) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Count the number of friends for each user
    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friends.size() + " friends.");
            temp = temp.next;
        }
    }

    // Display all users in the system
    public void displayAllUsers() {
        User temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.userID + ", Name: " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
        }
    }
}
