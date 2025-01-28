package singlylinkedlist.inventarymanagementsystem;

class Node {
    String itemName;
    int itemID;
    int quantity;
    double price;
    Node next;

    // Constructor to initialize a new item node
    public Node(String itemName, int itemID, int quantity, double price) {
        this.itemName = itemName;
        this.itemID = itemID;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}