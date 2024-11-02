public class Btree {
    private Bnode raiz;

    public Btree() {
        raiz = null;
    }

    public void add(int valor) {
        if (raiz != null) {
            raiz.add(valor);
        } else {
            raiz = new Bnode(valor);
        }
    }

    public void calcularMediaPorNivel() {
        int altura = (raiz != null) ? raiz.altura() : 0;
        for (int nivel = 0; nivel < altura; nivel++) {
            int[] somaNivel = {0};
            int[] contNivel = {0};
            System.out.print("Nível " + nivel + ": ");
            raiz.calcularMediaPorNivelRecursivo(nivel, somaNivel, contNivel);
            if (contNivel[0] > 0) {
                System.out.println(" | Média: " + (somaNivel[0] / contNivel[0]));
            }
        }
    }

    public double calcularMediaTotal() {
        if (raiz == null) return 0;
        int[] somaQuantidade = raiz.somarValores();
        return (double) somaQuantidade[0] / somaQuantidade[1];
    }

    public int altura() {
        return (raiz != null) ? raiz.altura() : 0;
    }
}
