public class AvlTree {
    private AvlNode raiz;

    public AvlTree() {
        raiz = null;
    }

    public void add(int valor) {
        if (raiz != null) {
            raiz = raiz.adicionar(valor);
        } else {
            raiz = new AvlNode(valor);
        }
    }

    public void show() {
        if (raiz != null) {
            raiz.show(0);
        }
    }

    public int calcularAltura() {
        return (raiz != null) ? raiz.calcularAltura() : 0;
    }

    public int somaValores() {
        return (raiz != null) ? raiz.somaValores() : 0;
    }

    public int tamanho() {
        return (raiz != null) ? raiz.tamanho() : 0;
    }
}
