package dataStructure;

public class Stack {

    private Node top;
    private int height;

    public class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public Stack(int value){
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    // Busca o topo da pilha
    public void getTop(){
        if (top != null) System.out.println("Topo: " + top.value);
        else System.out.println("Pilha vazia");
    }

    // Busca a altura da pilha
    public void getHeight(){
        System.out.println("Altura: " + height);
    }

    // Imprime a pilha
    public void print(){
        Node temp = top;
        while(temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Insere um novo elemento na pilha
    public void push(int value){
        Node newNode = new Node(value); // Criar novo nó
        if (height != 0) newNode.next = top; // Apontar para o antigo topo
        top = newNode; // Atualizar o topo
        height++; // Incrementar a altura
    }

    // Remove o elemento no topo da pilha
    public Node pop(){
        if (height == 0) return null;
        Node temp = top; // Armazena o topo para ser retornado
        top = top.next; // Atualiza o topo para o próximo nó
        temp.next = null; // Desconecta o nó removido
        height--; // Decrementa a altura
        return temp;
    }

    // Testes
    public static void main(String[] args) {
        System.out.println("=== Exemplo didático: Pilhas (Stack) ===");
        System.out.println("Operações demonstradas: push, pop, getTop, getHeight, print\n");

        Stack stack = new Stack(10);
        stack.getTop();    // Topo: 10
        stack.getHeight(); // Altura: 1
        stack.print();     // 10

        stack.push(20);
        stack.push(30);
        stack.getTop();    // Topo: 30
        stack.getHeight(); // Altura: 3
        stack.print();     // 30 20 10

        stack.pop();
        stack.getTop();    // Topo: 20
        stack.getHeight(); // Altura: 2
        stack.print();     // 20 10
    }
}
