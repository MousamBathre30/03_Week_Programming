package implementACustomHashMap;



import java.util.LinkedList;



import java.util.LinkedList;

class HashMap<K, V> {

    // Define the size of the HashMap
    private static final int SIZE = 16;

    // Array of LinkedLists to handle collisions
    private LinkedList<Entry<K, V>>[] table;

    // Constructor to initialize the HashMap
    public HashMap() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Define an Entry class to hold key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Hash function to determine the index for a given key
    private int hash(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    // Insertion operation (put)
    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> list = table[index];

        // Check if the key already exists in the list, if so, update the value
        for (Entry<K, V> entry : list) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        // Otherwise, add a new entry to the list
        list.add(new Entry<>(key, value));
    }

    // Retrieval operation (get)
    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> list = table[index];

        // Search the list for the key
        for (Entry<K, V> entry : list) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null; // Key not found
    }

    // Deletion operation (remove)
    public void remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> list = table[index];

        // Iterate over the list to find the key and remove it
        for (Entry<K, V> entry : list) {
            if (entry.key.equals(key)) {
                list.remove(entry);
                return;
            }
        }
    }

    // Display the contents of the HashMap
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            if (!table[i].isEmpty()) {
                System.out.print("Index " + i + ": ");
                for (Entry<K, V> entry : table[i]) {
                    System.out.print("[" + entry.key + "=" + entry.value + "] ");
                }
                System.out.println();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Insertion
        map.put("Apple", 3);
        map.put("Banana", 5);
        map.put("Orange", 2);

        // Retrieval
        System.out.println("Apple: " + map.get("Apple")); // Output: Apple: 3
        System.out.println("Banana: " + map.get("Banana")); // Output: Banana: 5

        // Deletion
        map.remove("Banana");
        System.out.println("Banana after removal: " + map.get("Banana")); // Output: Banana after removal: null

        // Display HashMap contents
        map.display();
    }
}
