package dataStructure;

//Árvores Binárias de Busca (Binary Search Trees - BST)
public class BinarySearchTree {
    public Node root; // raiz da árvore

    public static class Node {
        public int value; // valor recebido
        public Node left; // filho esquerdo
        public Node right; // filho direito

        public Node(int value) {
            this.value = value;
        }
    }

    // Inserção de valores
    public void insert(int value) {
        if (root == null) root = new Node(value); // inicializa a raiz se árvore estiver vazia
        else insert(root, value); // senão apenas chamamos o método recursivo
    }

    // método recursivo para inserir dados na árvore
    private void insert(final Node root, final int value) {
        if (root == null) return; // se árvore vazia
        if (root.value == value) return; // se valor for igual a raiz
        if (value > root.value) { // se valor for maior que a raiz
            if (root.right == null) root.right = new Node(value); // insere no filho direito
            else insert(root.right, value); // recursivo para inserir no filho direito
        } else {
            if (root.left == null) root.left = new Node(value); // insere no filho esquerdo
            else insert(root.left, value); // recursivo para inserir no filho esquerdo
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(final Node node) {
        // E R D -> esquerda - raiz - direita
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public boolean contains(int value) {
        return contains(root, value); // recursivo para procurar o valor
    }

    private boolean contains(final Node node, final int value) {
        if (node == null) return false;
        if (node.value == value) return true;
        return value > node.value ? contains(node.right, value) : contains(node.left, value); // boolean ternário, se for maior vai para direita, senão esquerda
    }

    // Utilitária para encontrar o menor valor
    public int minValue(Node currentNode){
        // menor valor está sempre na extremidade esquerda
        // enquanto houver filho esquerdo, procura o menor valor
        while(currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    // Método para remoção de um valor
    public void deleteNode(int value){
        root = deleteNode(root, value);
    }

    private Node deleteNode(final Node root, final int value) {
        if (root == null) return null;
        if (value < root.value) root.left = deleteNode(root.left, value); // se o valor for menor que a raiz, o lado esquerdo recebe o valor removido
        else if (value > root.value) root.right = deleteNode(root.right, value); // se o valor for maior que a raiz, o lado direito recebe o valor removido
        else
            if (root.left == null && root.right == null) return null; // se ambos os filhos forem nulos, retorna null
            else if (root.left == null) return root.right; // se o lado esquerdo for nulo, retorna o filho direito
            else if (root.right == null) return root.left; // se o lado direito for nulo, retorna o filho esquerdo
            else {
                // nó com dois filhos: obtém o menor valor do lado direito
                int minValue = minValue(root.right);
                root.value = minValue; // substitui o valor do nó pelo menor valor
                root.right = deleteNode(root.right, minValue); // remove o nó com o menor valor
            }
        return root;


    }

    // Exemplo de uso
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(37);
        tree.insert(66);
        tree.insert(42);
        tree.insert(11);
        tree.insert(72);
        tree.insert(8);
        tree.insert(17);
        tree.inOrder(); // 8 11 17 37 42 66 72

        System.out.println( tree.contains( 17 )); // true
        System.out.println( tree.contains( 10 )); // false

        tree.deleteNode( 66 );
        tree.inOrder(); // 8 11 17 37 42 72
    }
}
