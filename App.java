public class App {
    public static void main(String[] args) {
        Btree arvoreBST = new Btree();
        arvoreBST.add(10);
        arvoreBST.add(5);
        arvoreBST.add(15);
        arvoreBST.add(3);
        arvoreBST.add(8);
        arvoreBST.add(12);
        arvoreBST.add(18);
        arvoreBST.add(50);
        arvoreBST.add(30);
        arvoreBST.add(70);
        arvoreBST.add(20);
        arvoreBST.add(40);
        arvoreBST.add(60);
        arvoreBST.add(80);

        System.out.println("Árvore Binária de Pesquisa - Altura: " + arvoreBST.altura());
        System.out.println("Árvore Binária de Pesquisa - Média por nível:");
        arvoreBST.calcularMediaPorNivel();
        System.out.println("Árvore Binária de Pesquisa - Média total: " + arvoreBST.calcularMediaTotal());

        AvlTree arvoreAVL = new AvlTree();
        arvoreAVL.add(10);
        arvoreAVL.add(5);
        arvoreAVL.add(15);
        arvoreAVL.add(3);
        arvoreAVL.add(8);
        arvoreAVL.add(12);
        arvoreAVL.add(18);
        arvoreAVL.add(50);
        arvoreAVL.add(30);
        arvoreAVL.add(70);
        arvoreAVL.add(20);
        arvoreAVL.add(40);
        arvoreAVL.add(60);
        arvoreAVL.add(80);

        System.out.println("\nÁrvore AVL - Altura: " + arvoreAVL.altura());
        System.out.println("Árvore AVL - Média por nível:");
        arvoreAVL.calcularMediaPorNivel();
        System.out.println("Árvore AVL - Média total: " + arvoreAVL.calcularMediaTotal());
    }
}
