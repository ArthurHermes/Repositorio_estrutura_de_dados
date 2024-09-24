class No {
    int valor;
    No esquerdo, direito;

    public No(int item) {
        valor = item;
        esquerdo = direito = null;
    }
}

public class ArvoreBinaria {
    No raiz;

    ArvoreBinaria() {
        raiz = null;
    }

    // Inserir um novo nodo na árvore
    void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    No inserirRecursivo(No raiz, int valor) {
        // Se a árvore estiver vazia, cria um novo nodo
        if (raiz == null) {
            raiz = new No(valor);
            return raiz;
        }

        // Senão, percorre a árvore recursivamente
        if (valor < raiz.valor) {
            raiz.esquerdo = inserirRecursivo(raiz.esquerdo, valor);
        } else if (valor > raiz.valor) {
            raiz.direito = inserirRecursivo(raiz.direito, valor);
        }

        return raiz;
    }

    
    boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    boolean buscarRecursivo(No raiz, int valor) {
        if (raiz == null) {
            return false;
        }

        if (raiz.valor == valor) {
            return true;
        }

        if (valor < raiz.valor) {
            return buscarRecursivo(raiz.esquerdo, valor);
        } else {
            return buscarRecursivo(raiz.direito, valor);
        }
    }

    void remover(int valor) {
        raiz = removerRecursivo(raiz, valor);
    }

    No removerRecursivo(No raiz, int valor) {
        // Se a árvore está vazia
        if (raiz == null) {
            return raiz;
        }

        // Percorrendo a árvore para encontrar o nodo a ser removido
        if (valor < raiz.valor) {
            raiz.esquerdo = removerRecursivo(raiz.esquerdo, valor);
        } else if (valor > raiz.valor) {
            raiz.direito = removerRecursivo(raiz.direito, valor);
        } else {
            // Caso o nó tenha sido encontrado

            // Caso 1: Nó folha (sem filhos)
            if (raiz.esquerdo == null && raiz.direito == null) {
                return null;
            }

            // Caso 2: Nó com apenas um filho
            else if (raiz.esquerdo == null) {
                return raiz.direito;
            } else if (raiz.direito == null) {
                return raiz.esquerdo;
            }

            // Caso 3: Nó com dois filhos
            // Encontrar o menor valor na subárvore direita (sucessor)
            raiz.valor = valorMinimo(raiz.direito);

            // Remover o sucessor
            raiz.direito = removerRecursivo(raiz.direito, raiz.valor);
        }

        return raiz;
    }

    // Função para encontrar o menor valor de uma subárvore
    int valorMinimo(No raiz) {
        int minValor = raiz.valor;
        while (raiz.esquerdo != null) {
            minValor = raiz.esquerdo.valor;
            raiz = raiz.esquerdo;
        }
        return minValor;
    }
}

