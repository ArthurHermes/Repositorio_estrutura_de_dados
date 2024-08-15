public class PilhaDinamica {
    private Node topo;

    private class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public PilhaDinamica() {
        topo = null;
    }

    public void push(int data) {
        Node novoNode = new Node(data);
        novoNode.next = topo;
        topo = novoNode;
    }

    public int pop() {
        if (topo == null) {
            System.out.println("Pilha vazia.");
            return -1;
        }
        int data = topo.data;
        topo = topo.next;
        return data;
    }

    public int peek() {
        if (topo == null) {
            System.out.println("Pilha vazia.");
            return -1;
        }
        return topo.data;
    }

    public boolean isEmpty() {
        return topo == null;
    }

    public static void main(String[] args) {
        PilhaDinamica pilha = new PilhaDinamica();

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        System.out.println("Topo da pilha: " + pilha.peek());

        System.out.println("Elemento desempilhado: " + pilha.pop());
        System.out.println("Topo da pilha: " + pilha.peek());
    }
}