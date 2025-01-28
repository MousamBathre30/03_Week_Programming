package singlylinkedlist.socialMediaFriendConnection;

public class SocialMediaApp {
    public static void main(String[] args) {
        SocialMediaSystem system = new SocialMediaSystem();

        // Add users
        system.addUser(1, "Alice", 25);
        system.addUser(2, "Bob", 30);
        system.addUser(3, "Charlie", 28);
        system.addUser(4, "David", 35);

        // Add friends
        system.addFriend(1, 2); // Alice and Bob
        system.addFriend(1, 3); // Alice and Charlie
        system.addFriend(2, 4); // Bob and David

        // Display all users
        system.displayAllUsers();

        // Display friends of a user
        system.displayFriends(1); // Alice's friends

        // Find mutual friends between two users
        system.findMutualFriends(1, 2); // Alice and Bob
        system.findMutualFriends(1, 4); // Alice and David

        // Remove a friend connection
        system.removeFriend(1, 3); // Alice and Charlie

        // Display friends after removal
        system.displayFriends(1); // Alice's friends

        // Search for a user by Name
        system.searchUserByName("David");

        // Search for a user by ID
        User user = system.findUserByID(2);
        if (user != null) {
            System.out.println("User found by ID: " + user.name);
        }

        // Count the number of friends for each user
        system.countFriends();
    }
}