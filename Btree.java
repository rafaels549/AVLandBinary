public class Btree {
    Bnode raiz;

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
