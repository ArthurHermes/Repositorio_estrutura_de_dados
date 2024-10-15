package TabelaHash;

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);

        System.out.println("---------------------------------------------------------------------");
        int[] valores = {12, 25, 37, 41, 53, 64, 78, 89}; // Valores escolhidos pela professora
        for (int valor : valores) {
            hashTable.insert(valor);
        }
        System.out.println("---------------------------------------------------------------------");

        for (int valor : valores) {
            boolean found = hashTable.search(valor);
            System.out.println("Chave " + valor + (found ? " encontrada" : " não encontrada") + " na tabela.");
        }
        System.out.println("---------------------------------------------------------------------");

        int[] valoresParaRemover = {25, 53, 78}; // Valores desejados para serem removidos da TabelaHash
        for (int valor : valoresParaRemover) {
            hashTable.remove(valor);
        }

        // Laço de repetição para verificar se o valor foi ou não encontrado na TabelaHash após a remoção
        for (int valor : valores) {
            boolean found = hashTable.search(valor);
            System.out.println("Chave " + valor + (found ? " encontrada" : " não encontrada") + " na tabela após remoção.");
            System.out.println("---------------------------------------------------------------------");
        }
    }
}
