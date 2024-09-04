package Lista;


class Node<T> {
    T data;
    Node<T> next;
    Node<T> previous;

    Node(T value) {
        this.data = value;
        this.next = null;
        this.previous = null;
    }
}

public class listaduplamente<T> {
    private Node<T> base; 
    private Node<T> top;  
    private int size;     

    public listaduplamente() {
        this.base = null;
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(int pos, T value) {
        if (pos < 0 || pos > size) return;

        Node<T> newNode = new Node<>(value);

        if (pos == 0) {
            if (base == null) {
                base = top = newNode;
            } else {
                newNode.next = base;
                base.previous = newNode;
                base = newNode;
            }
        } else if (pos == size) {
            top.next = newNode;
            newNode.previous = top;
            top = newNode;
        } else {
            Node<T> current = base;
            for (int i = 0; i < pos; i++) {
                current = current.next;
            }
            newNode.next = current;
            newNode.previous = current.previous;
            current.previous.next = newNode;
            current.previous = newNode;
        }
        size++;
    }

    public void add(T value) {
        add(size, value);
    }

    public T remove(int pos) {
        if (pos < 0 || pos >= size) return null; 

        Node<T> toDelete;
        if (pos == 0) {
            toDelete = base;
            base = base.next;
            if (base != null) base.previous = null;
        } else if (pos == size - 1) {
            toDelete = top;
            top = top.previous;
            top.next = null;
        } else {
            Node<T> current = base;
            for (int i = 0; i < pos; i++) {
                current = current.next;
            }
            toDelete = current;
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }

        T value = toDelete.data;
        size--;
        return value;
    }

    public T remove(Node<T> node) {
        if (node == null) return null;

        if (node == base) {
            return remove(0);
        } else if (node == top) {
            return remove(size - 1);
        } else {
            node.previous.next = node.next;
            node.next.previous = node.previous;
            size--;
            return node.data;
        }
    }

    private Node<T> getNode(int pos) {
        if (pos < 0 || pos >= size) return null;

        Node<T> current = base;
        for (int i = 0; i < pos; i++) {
            current = current.next;
        }
        return current;
    }
    public T get(int pos) {
        Node<T> node = getNode(pos);
        return node != null ? node.data : null;
    }

    public void set(int pos, T value) {
        Node<T> node = getNode(pos);
        if (node != null) {
            node.data = value;
        }
    }

    public int find(T value) {
        Node<T> current = base;
        int index = 0;
        while (current != null) {
            if (current.data.equals(value)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1; 
    }
}