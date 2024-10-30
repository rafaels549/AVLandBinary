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

    public void show(int nivel) {
        System.out.println("Valor: " + x + ", Nível: " + nivel);
        if (esq != null) esq.show(nivel + 1);
        if (dir != null) dir.show(nivel + 1);
    }

    public int calcularAltura() {
        int alturaEsq = (esq != null) ? esq.calcularAltura() : 0;
        int alturaDir = (dir != null) ? dir.calcularAltura() : 0;
        return 1 + Math.max(alturaEsq, alturaDir);
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

    public int calcularMedia(int nivel) {
        return somaValores() / tamanho();
    }
}
