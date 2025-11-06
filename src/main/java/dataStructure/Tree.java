package dataStructure;

// Árvore binária simples
// Cheia: quando todos os níveis, exceto possivelmente o último, estão completos, e todos os nós estão o mais à esquerda possível
// Perfeita: quando todos os níveis estão completos
// Completa: quando todos os níveis, exceto possivelmente o último, estão completos, e todos os nós do último nível estão o mais à esquerda possível

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    public Node root; // nó raiz (índice 0)

    public  static class Node {
        public int value; // o valor a ser adicionado
        public Node left; // o filho da esquerda
        public Node right; // o filho da direita

        public Node(int value) {
            this.value = value;
        }

        // Verifica se o nó é folha (sem filhos)
        public boolean isLeaf() {
            // Espaço à esquerda e à direita vazios?
            return left == null && right == null;
        }
    }

    public void insert(int value) {
        if (root == null) root = new Node(value); // inicializa a raiz
        else {
            Node newNode = new Node(value);
            // Usando os Utils
            Queue<Node> fila = new LinkedList<>();
            fila.add(root); // começa da raiz
            while(!fila.isEmpty()){
                Node current = fila.remove(); // nó atual
                // verifica se o lado esquerdo está vazio
                if (current.left == null) {
                    // insere o novo nó à esquerda
                    current.left = newNode;
                    break; // sai do loop ao inserir o elemento
                // senão insere na fila o lado esquerdo
                } else fila.add(current.left);
                // repete o processo para o lado direito
                if (current.right == null) {
                    current.right = newNode;
                    break;
                } else fila.add(current.right);
            }
        }
    }

    // Leitura PRÉ-ORDEM: Raiz - esquerda - direita
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(final Node node){
        // R E D
        if (node == null) return;
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // Leitura EM ORDEM: esquerda - Raiz - direita
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(final Node node){
        // E R D
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    // Leitura PÓS-ORDEM: esquerda - direita - Raiz
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(final Node node) {
        // E D R
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    // Busca em Largura (BFS)
    public void BFS(){
        if (root == null) return;
        Queue<Node> fila = new LinkedList<>();
        fila.add(root);
        while(!fila.isEmpty()){
            Node current = fila.remove();
            if (current.left != null) fila.add(current.left);
            if (current.right != null) fila.add(current.right);

            System.out.print(current.value + " ");
        }
    }

    // Busca em Profundidade (DFS) = Busca Pré-ordem

//Testes
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(37);
        tree.insert(11);
        tree.insert(8);
        tree.insert(17);
        tree.insert(66);
        tree.insert(42);
        tree.insert(72);

        System.out.println("Raiz: " + tree.root.value);
        System.out.println("Filho da esquerda: " + tree.root.left.value);
        System.out.println("Filho da direita: " + tree.root.right.value);

        System.out.println("\nPré-ordem:");
        tree.preOrder();

        System.out.println("\nEm ordem:");
        tree.inOrder();
    }
}
