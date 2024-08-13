public class PilhaEstatica{
    private int[] numero;
    private int topo;
    
    public PilhaEstatica(int tamanho){
        numero = new int[tamanho];
        topo = - 1;
    }

    public void empilhar(int item){
        if (topo == numero.length -1){
            throw new RuntimeException("Pilha esta cheia");
        }
        numero[++topo] = item
    }
}