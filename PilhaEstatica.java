public class PilhaEstatica {
    private int[] numero;
    private int topo;

    public PilhaEstatica(int tamanho) {
        numero = new int[tamanho];
        topo = -1;
    }

    public void empilhar(int item) {
        if (topo == numero.length - 1) {
            throw new RuntimeException("Pilha está cheia");
        }
        numero[++topo] = item;
    }

    public int desempilhar() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha está vazia");
        }
        return numero[topo--];
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == numero.length - 1;
    }


    public static void main(String[] args) {
        PilhaEstatica p = new PilhaEstatica(5);

        p.empilhar(2);

        System.out.println(p.isEmpty());

        System.out.println(p.isFull());

    }

}
