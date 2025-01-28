package doublylinkedlist.undoRedoFuncationality;

public class TextEditorApp {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);  // Limit history to 10 states

        // Simulate typing text
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");

        editor.displayCurrentState();

        // Undo the last action
        editor.undo();
        editor.undo();

        // Redo the undone actions
        editor.redo();

        // Add more text
        editor.addState("Hello World! How are you?");
        editor.addState("Hello World! How are you today?");

        // Display current state
        editor.displayCurrentState();

        // Display the full history
        editor.displayHistory();
    }
}