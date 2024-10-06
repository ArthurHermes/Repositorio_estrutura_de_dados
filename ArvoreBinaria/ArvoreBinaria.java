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


    void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    No inserirRecursivo(No raiz, int valor) {
        if (raiz == null) {
            raiz = new No(valor);
            return raiz;
        }


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

        if (raiz == null) {
            return raiz;
        }

       
        if (valor < raiz.valor) {
            raiz.esquerdo = removerRecursivo(raiz.esquerdo, valor);
        } else if (valor > raiz.valor) {
            raiz.direito = removerRecursivo(raiz.direito, valor);
        } else {

            if (raiz.esquerdo == null && raiz.direito == null) {
                return null;
            }


            else if (raiz.esquerdo == null) {
                return raiz.direito;
            } else if (raiz.direito == null) {
                return raiz.esquerdo;
            }


            raiz.valor = valorMinimo(raiz.direito);


            raiz.direito = removerRecursivo(raiz.direito, raiz.valor);
        }

        return raiz;
    }

    int valorMinimo(No raiz) {
        int minValor = raiz.valor;
        while (raiz.esquerdo != null) {
            minValor = raiz.esquerdo.valor;
            raiz = raiz.esquerdo;
        }
        return minValor;
    }
}

