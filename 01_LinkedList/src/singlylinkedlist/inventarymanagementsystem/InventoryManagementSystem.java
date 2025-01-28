package singlylinkedlist.inventarymanagementsystem;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        SinglyLinkedList inventory = new SinglyLinkedList();

        // Add some items to the inventory
        inventory.addAtEnd("Laptop", 101, 5, 70000);
        inventory.addAtEnd("Mouse", 102, 50, 500);
        inventory.addAtBeginning("Keyboard", 103, 20, 1500);
        inventory.addAtPosition("Monitor", 104, 10, 8000, 2);

        // Display the inventory
        System.out.println("Inventory:");
        inventory.displayInventory();

        // Search for an item
        System.out.println("\nSearch for Item:");
        inventory.searchItem("Mouse");

        // Update the quantity of an item
        inventory.updateQuantityByID(101, 10);
        System.out.println("\nInventory after updating quantity:");
        inventory.displayInventory();

        // Remove an item
        inventory.removeItemByID(102);
        System.out.println("\nInventory after removing an item:");
        inventory.displayInventory();

        // Calculate total value of inventory
        System.out.println("\nTotal Value of Inventory:");
        inventory.calculateTotalValue();

        // Sort inventory by price in ascending order
        inventory.sortInventory("price", true);
        System.out.println("\nInventory sorted by price (ascending):");
        inventory.displayInventory();

        // Sort inventory by name in descending order
        inventory.sortInventory("name", false);
        System.out.println("\nInventory sorted by name (descending):");
        inventory.displayInventory();
    }
}