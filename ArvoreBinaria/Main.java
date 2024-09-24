public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(70);
        arvore.inserir(60);
        arvore.inserir(80);

        int valorBuscar = 60;
        System.out.println("\nBuscando o valor " + valorBuscar + ": " + (arvore.buscar(valorBuscar) ? "Encontrado" : "Não encontrado"));
        

        arvore.remover(60);

        System.out.println("\nBuscando o valor " + valorBuscar + ": " + (arvore.buscar(valorBuscar) ? "Encontrado" : "Nao encontrado"));

    
    }
}