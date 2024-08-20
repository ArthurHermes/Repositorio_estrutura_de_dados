public class FilaCircular<T> {
    private int top = -1;
    private int base = 0;
    private int tamanho;
    private int count = 0; // Track the number of elements
    private T[] letras;

    @SuppressWarnings("unchecked")
    public FilaCircular(int tamanho) {
        this.tamanho = tamanho;
        letras = (T[]) new Object[tamanho];
    }

    public void adicionar(T letra) {
        if (isFull()) {
            throw new IllegalStateException("Fila cheia");
        }
        top = (top + 1) % tamanho;
        letras[top] = letra;
        count++;
    } 

    public T remover() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }
        T letra = letras[base];
        letras[base] = null;
        base = (base + 1) % tamanho;
        count--;
        return letra;
    }

    public boolean isFull() {
        return count == tamanho; // Queue is full if the count equals the size
    }

    public boolean isEmpty() {
        return count == 0; // Queue is empty if count is zero
    }

    

}
