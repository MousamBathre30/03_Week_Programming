package doublylinkedlist.undoRedoFuncationality;

class TextEditor {
    private TextState currentState;
    private TextState head;
    private TextState tail;
    private int historyLimit;
    private int historySize;

    public TextEditor(int historyLimit) {
        this.historyLimit = historyLimit;
        this.historySize = 0;
        this.currentState = null;
        this.head = null;
        this.tail = null;
    }

    // Add a new text state
    public void addState(String newText) {
        TextState newState = new TextState(newText);

        if (historySize == historyLimit) {
            // Remove the oldest state (head) if history exceeds the limit
            head = head.next;
            head.prev = null;
            historySize--;
        }

        if (currentState != null) {
            currentState.next = newState;
            newState.prev = currentState;
            currentState = newState;  // Move the current state to the new state
        } else {
            // First state
            currentState = newState;
            head = newState;
            tail = newState;
        }

        historySize++;
    }

    // Undo operation: revert to the previous state
    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            System.out.println("Undo: " + currentState.text);
        } else {
            System.out.println("No previous state to undo.");
        }
    }

    // Redo operation: revert to the next state after undo
    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            System.out.println("Redo: " + currentState.text);
        } else {
            System.out.println("No next state to redo.");
        }
    }

    // Display the current state of the text
    public void displayCurrentState() {
        if (currentState != null) {
            System.out.println("Current State: " + currentState.text);
        } else {
            System.out.println("No current state.");
        }
    }

    // Display the entire history of text states
    public void displayHistory() {
        TextState temp = head;
        while (temp != null) {
            System.out.println(temp.text);
            temp = temp.next;
        }
    }
}
