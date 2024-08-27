package Lista;


class Node<T> {
    T data;        // Dado armazenado no nó
    Node<T> next;  // Referência para o próximo nó

    // Construtor
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

// Definição da classe ListaEncadeada
public class ListaEncadeada<T> {
    private Node<T> base;  // Referência ao primeiro nó (base)
    private Node<T> top;   // Referência ao último nó (topo)
    private int size;      // Tamanho da lista

    // Construtor
    public ListaEncadeada() {
        this.base = null;
        this.top = null;
        this.size = 0;
    }

    // Verifica se a lista está vazia
    public boolean isEmpty() {
        return size == 0;
    }

    // Verifica se a lista está cheia
    public boolean isFull() {
        return false; // Como é uma lista encadeada, teoricamente nunca estará cheia
    }

    // Retorna o tamanho da lista
    public int getSize() {
        return size;
    }

    // Adiciona um valor à lista em uma posição específica
    public void add(int pos, T value) {
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }

        Node<T> newNode = new Node<>(value);

        if (pos == 0) { // Adicionar na base
            newNode.next = base;
            base = newNode;
            if (size == 0) {
                top = base;
            }
        } else {
            Node<T> current = base;
            for (int i = 0; i < pos - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            if (newNode.next == null) {
                top = newNode;
            }
        }
        size++;
    }

    // Adiciona um valor ao final da lista
    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        if (isEmpty()) {
            base = newNode;
            top = newNode;
        } else {
            top.next = newNode;
            top = newNode;
        }
        size++;
    }

    // Remove o nó na posição especificada e retorna o valor removido
    public T remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }

        Node<T> removedNode;

        if (pos == 0) {
            removedNode = base;
            base = base.next;
            if (size == 1) {
                top = null;
            }
        } else {
            Node<T> current = base;
            for (int i = 0; i < pos - 1; i++) {
                current = current.next;
            }
            removedNode = current.next;
            current.next = removedNode.next;
            if (current.next == null) {
                top = current;
            }
        }

        size--;
        return removedNode.data;
    }

    // Remove um nó específico
    public T remove(Node<T> node) {
        int pos = find(node.data);
        if (pos != -1) {
            return remove(pos);
        }
        return null;
    }

    // Retorna o nó na posição especificada
    public Node<T> getNode(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }

        Node<T> current = base;
        for (int i = 0; i < pos; i++) {
            current = current.next;
        }

        return current;
    }

    // Retorna o valor na posição especificada
    public T get(int pos) {
        return getNode(pos).data;
    }

    // Define o valor em uma posição específica
    public void set(int pos, T value) {
        Node<T> node = getNode(pos);
        node.data = value;
    }

    // Encontra a posição de um determinado valor na lista
    public int find(T value) {
        Node<T> current = base;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(value)) {
                return i;
            }
            current = current.next;
        }
        return -1; // Retorna -1 se o valor não for encontrado
    }

    // Método principal para testar a classe ListaEncadeada
    public static void main(String[] args) {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.add(10);
        lista.add(20);
        lista.add(30);

        System.out.println("Lista após adicionar elementos:");
        for (int i = 0; i < lista.getSize(); i++) {
            System.out.println(lista.get(i));
        }

        lista.remove(1);

        System.out.println("Lista após remover elemento na posição 1:");
        for (int i = 0; i < lista.getSize(); i++) {
            System.out.println(lista.get(i));
        }

        lista.set(1, 40);
        System.out.println("Lista após definir novo valor na posição 1:");
        for (int i = 0; i < lista.getSize(); i++) {
            System.out.println(lista.get(i));
        }

        int pos = lista.find(40);
        System.out.println("Posição do elemento 40: " + pos);
    }
}
