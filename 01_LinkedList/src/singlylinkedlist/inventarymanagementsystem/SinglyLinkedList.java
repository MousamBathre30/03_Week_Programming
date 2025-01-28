package singlylinkedlist.inventarymanagementsystem;

class SinglyLinkedList {
    private Node head;

    // Add an item at the beginning
    public void addAtBeginning(String itemName, int itemID, int quantity, double price) {
        Node newNode = new Node(itemName, itemID, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    // Add an item at the end
    public void addAtEnd(String itemName, int itemID, int quantity, double price) {
        Node newNode = new Node(itemName, itemID, quantity, price);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Add an item at a specific position
    public void addAtPosition(String itemName, int itemID, int quantity, double price, int position) {
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(itemName, itemID, quantity, price);
            return;
        }
        Node newNode = new Node(itemName, itemID, quantity, price);
        Node current = head;
        int count = 1;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Position out of range.");
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Remove an item based on Item ID
    public void removeItemByID(int itemID) {
        if (head == null) {
            System.out.println("The inventory is empty.");
            return;
        }
        if (head.itemID == itemID) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.itemID != itemID) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Item not found.");
        } else {
            current.next = current.next.next;
        }
    }

    // Update the quantity of an item by Item ID
    public void updateQuantityByID(int itemID, int newQuantity) {
        Node current = head;
        while (current != null) {
            if (current.itemID == itemID) {
                current.quantity = newQuantity;
                return;
            }
            current = current.next;
        }
        System.out.println("Item not found.");
    }

    // Search for an item based on Item ID or Item Name
    public void searchItem(String nameOrID) {
        Node current = head;
        boolean found = false;
        while (current != null) {
            if (String.valueOf(current.itemID).equals(nameOrID) || current.itemName.equalsIgnoreCase(nameOrID)) {
                System.out.println("Item Found: " + current.itemName + ", ID: " + current.itemID +
                        ", Quantity: " + current.quantity + ", Price: " + current.price);
                found = true;
                break;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("Item not found.");
        }
    }

    // Calculate and display the total value of inventory
    public void calculateTotalValue() {
        double totalValue = 0;
        Node current = head;
        while (current != null) {
            totalValue += current.price * current.quantity;
            current = current.next;
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }

    // Sort the inventory based on Item Name or Price in ascending/descending order
    public void sortInventory(String criteria, boolean ascending) {
        if (head == null || head.next == null) {
            return; // No need to sort if the list is empty or has one item
        }
        head = mergeSort(head, criteria, ascending);
    }

    private Node mergeSort(Node head, String criteria, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(head, criteria, ascending);
        Node right = mergeSort(nextOfMiddle, criteria, ascending);

        return sortedMerge(left, right, criteria, ascending);
    }

    private Node sortedMerge(Node left, Node right, String criteria, boolean ascending) {
        if (left == null) return right;
        if (right == null) return left;

        boolean condition;
        if (criteria.equalsIgnoreCase("name")) {
            condition = ascending ? left.itemName.compareToIgnoreCase(right.itemName) <= 0
                    : left.itemName.compareToIgnoreCase(right.itemName) > 0;
        } else { // criteria = price
            condition = ascending ? left.price <= right.price : left.price > right.price;
        }

        if (condition) {
            left.next = sortedMerge(left.next, right, criteria, ascending);
            return left;
        } else {
            right.next = sortedMerge(left, right.next, criteria, ascending);
            return right;
        }
    }

    private Node getMiddle(Node head) {
        if (head == null) return head;
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Display the inventory
    public void displayInventory() {
        Node current = head;
        while (current != null) {
            System.out.println("Item Name: " + current.itemName + ", ID: " + current.itemID +
                    ", Quantity: " + current.quantity + ", Price: " + current.price);
            current = current.next;
        }
    }
}