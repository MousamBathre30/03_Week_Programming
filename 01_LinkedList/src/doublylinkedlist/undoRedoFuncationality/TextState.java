package doublylinkedlist.undoRedoFuncationality;

class TextState {
    String text;
    TextState prev, next;

    public TextState(String text) {
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}