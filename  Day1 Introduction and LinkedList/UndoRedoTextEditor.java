class TextState {
    String text;      // The current state of the text
    TextState prev;   // Pointer to the previous state (undo history)
    TextState next;   // Pointer to the next state (redo history)


    // Constructor to initialize the text state
    public TextState(String text) {
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}


class TextEditor {
    private TextState currentState;   // Current state of the text
    private int historySize;          // Maximum number of states to keep in history
    private TextState firstState;     // The first state (oldest state)
    private int currentSize;          // Current size of the history list


    // Constructor to initialize the text editor
    public TextEditor(int historySize) {
        this.historySize = historySize;
        this.currentSize = 0;
        this.firstState = null;
        this.currentState = null;
    }


    // Add a new state to the history (after a user action like typing)
    public void addState(String text) {
        TextState newState = new TextState(text);


        // If there are no states yet, this is the first state
        if (firstState == null) {
            firstState = newState;
            currentState = newState;
        } else {
            // Add the new state to the end of the list
            currentState.next = newState;
            newState.prev = currentState;
            currentState = newState;
        }


        // If the history exceeds the limit, remove the oldest state (first state)
        if (currentSize == historySize) {
            firstState = firstState.next;
            firstState.prev = null;
        } else {
            currentSize++;
        }


        // Clear redo history when a new state is added
        currentState.next = null;
    }


    // Undo functionality: move to the previous state
    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            System.out.println("Undo: " + currentState.text);
        } else {
            System.out.println("No more states to undo.");
        }
    }


    // Redo functionality: move to the next state
    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            System.out.println("Redo: " + currentState.text);
        } else {
            System.out.println("No more states to redo.");
        }
    }


    // Display the current text state
    public void displayCurrentState() {
        if (currentState != null) {
            System.out.println("Current state: " + currentState.text);
        } else {
            System.out.println("No text available.");
        }
    }
}


public class UndoRedoTextEditor {
    public static void main(String[] args) {
        // Create a text editor with a history size limit of 5 states
        TextEditor editor = new TextEditor(5);


        // Simulate user typing and perform actions
        editor.addState("Hello");
        editor.addState("Hello, World!");
        editor.addState("Hello, World! How are you?");
        editor.addState("Hello, World! How are you? I'm fine.");
        editor.addState("Hello, World! How are you? I'm fine. How about you?");


        // Display current state
        editor.displayCurrentState();


        // Undo and Redo actions
        editor.undo();
        editor.undo();
        editor.redo();


        // Add a new state after undo/redo
        editor.addState("Hello, World!");
        editor.displayCurrentState();


        // Undo until the beginning
        editor.undo();
        editor.undo();
        editor.undo();
        editor.undo();


        // Test redo functionality after undoing all states
        editor.redo();
        editor.redo();
    }
}


