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

    public int calcularFatorBalanceamento() {
        int alturaEsq = (esq != null) ? esq.altura : 0;
        int alturaDir = (dir != null) ? dir.altura : 0;
        return alturaEsq - alturaDir;
    }

    public AvlNode adicionar(int valor) {
        // Adiciona o valor normalmente
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
            return this; // Não permitir duplicatas
        }

        // Atualiza a altura do nó atual
        atualizarAltura();

        // Calcula o fator de balanceamento
        int fatorBalanceamento = calcularFatorBalanceamento();

        // Rotação à esquerda
        if (fatorBalanceamento > 1 && valor < esq.x) {
            return rotacaoDireita();
        }
        // Rotação à direita
        if (fatorBalanceamento < -1 && valor > dir.x) {
            return rotacaoEsquerda();
        }
        // Rotação dupla à esquerda
        if (fatorBalanceamento > 1 && valor > esq.x) {
            esq = esq.rotacaoEsquerda();
            return rotacaoDireita();
        }
        // Rotação dupla à direita
        if (fatorBalanceamento < -1 && valor < dir.x) {
            dir = dir.rotacaoDireita();
            return rotacaoEsquerda();
        }

        return this; // Retorna o nó (pode ser o novo nó após rotação)
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

    public void show(int nivel) {
        System.out.println("Valor: " + x + ", Nível: " + nivel);
        if (esq != null) esq.show(nivel + 1);
        if (dir != null) dir.show(nivel + 1);
    }

    public int calcularAltura() {
        return altura;
    }

    public int somaValores() {
        int somaEsq = (esq != null) ? esq.somaValores() : 0;
        int somaDir = (dir != null) ? dir.somaValores() : 0;
        return x + somaEsq + somaDir;
    }

    public int tamanho() {
        int tamEsq = (esq != null) ? esq.tamanho() : 0;
        int tamDir = (dir != null) ? dir.tamanho() : 0;
        return 1 + tamEsq + tamDir;
    }

    public int calcularMedia() {
        return somaValores() / tamanho();
    }
}
