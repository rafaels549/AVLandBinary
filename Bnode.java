public class Bnode {
    private int x;
    private Bnode esq, dir;

    public Bnode(int valor) {
        x = valor;
        esq = null;
        dir = null;
    }

    public void add(int valor) {
        if (valor > x) {
            if (dir != null) dir.add(valor);
            else dir = new Bnode(valor);
        } else if (valor < x) {
            if (esq != null) esq.add(valor);
            else esq = new Bnode(valor);
        } else {
            System.out.println("Valor já inserido: " + valor);
        }
    }

    public void calcularMediaPorNivelRecursivo(int nivel, int[] somaNivel, int[] contNivel) {
        if (nivel == 0) {
            System.out.print(x + " ");  // Exibe o valor do nó no nível atual
            somaNivel[0] += x;
            contNivel[0]++;
        } else {
            if (esq != null) esq.calcularMediaPorNivelRecursivo(nivel - 1, somaNivel, contNivel);
            if (dir != null) dir.calcularMediaPorNivelRecursivo(nivel - 1, somaNivel, contNivel);
        }
    }

    public int altura() {
        int alturaEsq = (esq != null) ? esq.altura() : 0;
        int alturaDir = (dir != null) ? dir.altura() : 0;
        return 1 + Math.max(alturaEsq, alturaDir);
    }
    public int[] somarValores() {
        int soma = this.x;
        int quantidade = 1;

        if (esq != null) {
            int[] esquerdaSomaQuantidade = esq.somarValores();
            soma += esquerdaSomaQuantidade[0];
            quantidade += esquerdaSomaQuantidade[1];
        }

        if (dir != null) {
            int[] direitaSomaQuantidade = dir.somarValores();
            soma += direitaSomaQuantidade[0];
            quantidade += direitaSomaQuantidade[1];
        }

        return new int[]{soma, quantidade};
    }

}