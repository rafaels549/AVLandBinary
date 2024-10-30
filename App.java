public class App {
    public static void main(String[] args) {
        // Criar árvore binária de pesquisa
        Btree arvoreBST = new Btree();
        int[] valores = {10, 5, 15, 3, 8, 12, 18, 50, 30, 70, 20, 40, 60, 80};

        for (int valor : valores) {
            arvoreBST.add(valor);
        }

        // Mostrar a árvore binária de pesquisa
        System.out.println("Árvore Binária de Pesquisa:");
        arvoreBST.show();
        System.out.println("Altura da árvore: " + arvoreBST.calcularAltura());
        System.out.println("Média dos valores: " + arvoreBST.somaValores() / arvoreBST.tamanho());

        // Criar árvore AVL
        AvlTree arvoreAVL = new AvlTree();
        for (int valor : valores) {
            arvoreAVL.add(valor);
        }

        // Mostrar a árvore AVL
        System.out.println("\nÁrvore AVL:");
        arvoreAVL.show();
        System.out.println("Altura da árvore: " + arvoreAVL.calcularAltura());
        System.out.println("Média dos valores: " + arvoreAVL.somaValores() / arvoreAVL.tamanho());
    }
}
