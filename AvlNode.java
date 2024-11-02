public class AvlNode {
    private int x;
    private AvlNode esq, dir;
    private int altura;

    public AvlNode(int valor) {
        x = valor;
        esq = null;
        dir = null;
        altura = 1;
    }

    public void atualizarAltura() {
        int alturaEsq = (esq != null) ? esq.altura : 0;
        int alturaDir = (dir != null) ? dir.altura : 0;
        altura = 1 + Math.max(alturaEsq, alturaDir);
    }

    public AvlNode adicionar(int valor) {
        if (valor < x) {
            if (esq != null) {
                esq = esq.adicionar(valor);
            } else {
                esq = new AvlNode(valor);
            }
        } else if (valor > x) {
            if (dir != null) {
                dir = dir.adicionar(valor);
            } else {
                dir = new AvlNode(valor);
            }
        } else {
            return this;
        }
        atualizarAltura();
        int fatorBalanceamento = calcularFatorBalanceamento();

        if (fatorBalanceamento > 1 && valor < esq.x) {
            return rotacaoDireita();
        }
        if (fatorBalanceamento < -1 && valor > dir.x) {
            return rotacaoEsquerda();
        }
        if (fatorBalanceamento > 1 && valor > esq.x) {
            esq = esq.rotacaoEsquerda();
            return rotacaoDireita();
        }
        if (fatorBalanceamento < -1 && valor < dir.x) {
            dir = dir.rotacaoDireita();
            return rotacaoEsquerda();
        }
        return this;
    }

    public int calcularFatorBalanceamento() {
        int alturaEsq = (esq != null) ? esq.altura : 0;
        int alturaDir = (dir != null) ? dir.altura : 0;
        return alturaEsq - alturaDir;
    }

    public AvlNode rotacaoDireita() {
        AvlNode novaRaiz = esq;
        esq = novaRaiz.dir;
        novaRaiz.dir = this;
        atualizarAltura();
        novaRaiz.atualizarAltura();
        return novaRaiz;
    }

    public AvlNode rotacaoEsquerda() {
        AvlNode novaRaiz = dir;
        dir = novaRaiz.esq;
        novaRaiz.esq = this;
        atualizarAltura();
        novaRaiz.atualizarAltura();
        return novaRaiz;
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
    public int altura() {
        int alturaEsquerda = (esq != null) ? esq.altura() : 0;
        int alturaDireita = (dir != null) ? dir.altura() : 0;
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }
}
