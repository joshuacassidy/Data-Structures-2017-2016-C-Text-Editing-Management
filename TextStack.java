public class TextStack implements IStack {

    private Node top;
    private int size;

    @Override
    public void push(String data) {
        if (isEmpty()) {
            top = new Node(data);
        } else {
            Node temp = top;
            top = new Node(data);
            top.setNext(temp);
        }
        size++;
    }

    @Override
    public Node pop() {
        if (isEmpty()) {
            throw new StackIsEmptyException("Cannot pop on a empty stack");
        } else {
            Node temp = top;
            top = top.getNext();
            size--;
            return temp;
        }
    }

    @Override
    public Node peek() {
        if (isEmpty()) {
            throw new StackIsEmptyException("Cannot peek on a empty stack");
        } else {
            return top;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String str = "";
        Node temp = top;
        while (temp != null) {
            str += top.getNext() == null ? temp.getData() : temp.getData() + " ";
            temp = temp.getNext();
        }
        return str;
    }
}
