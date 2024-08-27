package Lista;

public class StaticList {
    private int[] data;
    private int size;

    public StaticList(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public void clear() {
        size = 0;
    }

    public void add(int data) {
        if (isFull()) {
            System.out.println("A lista está cheia.");
            return;
        }
        this.data[size++] = data;
    }

    public void add(int data, int pos) {
        if (isFull()) {
            System.out.println("A lista está cheia.");
            return;
        }
        if (pos < 0 || pos > size) {
            System.out.println("Posição inválida.");
            return;
        }
        for (int i = size; i > pos; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[pos] = data;
        size++;
    }

    // Remove um item de uma posição específica da lista
    public int remove(int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("Posição inválida.");
            return -1; // Retorna um valor inválido
        }
        int removedData = this.data[pos];
        for (int i = pos; i < size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        size--;
        return removedData;
    }

    // Verifica se a lista está vazia
    public boolean isEmpty() {
        return size == 0;
    }

    // Verifica se a lista está cheia
    public boolean isFull() {
        return size == data.length;
    }

    // Define um valor em uma posição específica
    public void setData(int data, int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("Posição inválida.");
            return;
        }
        this.data[pos] = data;
    }

    // Obtém o valor em uma posição específica
    public int getData(int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("Posição inválida.");
            return -1; // Retorna um valor inválido
        }
        return this.data[pos];
    }

    // Retorna o tamanho atual da lista
    public int getSize() {
        return size;
    }

    // Encontra a posição de um determinado valor na lista
    public int find(int data) {
        for (int i = 0; i < size; i++) {
            if (this.data[i] == data) {
                return i;
            }
        }
        return -1;
    }

}
