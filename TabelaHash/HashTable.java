package TabelaHash;


public class HashTable {
    private Integer[] table;
    private int size;

    public HashTable(int size) {
        this.size = size;
        this.table = new Integer[size];
    }


    private int hashFunction(int key) {
        double A = (Math.sqrt(5) - 1) / 2; // // Notação de Knuth --> link(https://pt.wikipedia.org/wiki/Nota%C3%A7%C3%A3o_de_Knuth)
        return (int) (size * ((key * A) % 1));
    }

    public void insert(int key) { // função de inserção
        int index = hashFunction(key);
        int originalIndex = index;
        while (table[index] != null && table[index] != 0) {
            index = (index + 1) % size;
            if (index == originalIndex) {
                System.out.println("Tabela cheia! Não é possível inserir a chave " + key);
                return;
            }
        }
        table[index] = key;
        System.out.println("Chave " + key + " inserida na posição " + index + ".");
    }

    public boolean search(int key) { // função de busca
        int index = hashFunction(key);
        int originalIndex = index;
        while (table[index] != null) {
            if (table[index] == key) {
                return true;
            }
            index = (index + 1) % size;
            if (index == originalIndex) {
                break;
            }
        }
        return false;
    }

    public void remove(int key) { // remoção de valor da TabelaHash
        int index = hashFunction(key);
        int originalIndex = index;
        while (table[index] != null) {
            if (table[index] == key) {
                table[index] = 0;
                System.out.println("Chave " + key + " removida da posição " + index + ".");
                return;
            }
            index = (index + 1) % size;
            if (index == originalIndex) {
                break;
            }
        }
        System.out.println("Chave " + key + " não encontrada.");
    }
}
