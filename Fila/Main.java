public class Main{
    public static void main(String[] args) {
        FilaCircular<String> fila = new FilaCircular<>(5);

        // Adding elements to the queue
        fila.adicionar("A");
        fila.adicionar("B");
        fila.adicionar("C");
        fila.adicionar("D");
        fila.adicionar("E");
    }
}