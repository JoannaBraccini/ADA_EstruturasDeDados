package dataStructure;

public class Queue {
    private Node first;
    private Node last;
    private int length;

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

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length ++;
    }
    // Busca o primeiro elemento da fila
    public void getFirst(){
        if (first != null) System.out.println("First: " + first.value);
        else System.out.println("Fila vazia");
    }
    // Busca o último elemento da fila
    public void getLast(){
        if (last != null) System.out.println("Last: " + last.value);
        else System.out.println("Fila vazia");
    }
    // Busca a quantidade de elementos na fila
    public void getLength(){
        System.out.println("Length: " + length);
    }
    // Imprime a fila
    public void print(){
        Node temp = first; // para percorrer a fila deve ser temporário
        // enquanto temp não for nulo, imprime o valor e avança para o próximo
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    // Insere um novo elemento no fim da fila
    public void enqueue(int value){
        Node newNode = new Node(value);
        // Caso especial: se a fila estiver vazia
        if (length == 0) first = newNode; // primeiro elemento da fila aponta para o novo elemento
        else last.next = newNode; // aponta para o próximo elemento da fila
        // o último elemento da fila sempre aponta para o novo elemento:
        last = newNode;
        length++; // incrementa o contador de elementos na fila
    }
    // Remove o primeiro elemento da fila
    public Node dequeue(){
        // Caso a fila já esteja vazia
        if (length == 0) return null;
        Node temp = first; // guarda o primeiro elemento da fila para ser retornado
        if (length == 1) {
            // aponta para null se a fila tiver apenas um elemento
            last = null;
            first = null;
        } else {
            first = first.next; // aponta para o próximo elemento da fila
            temp.next = null; // desconecta o elemento removido do resto da fila
        }
        length--; // decrementa o contador de elementos na fila
        return temp; // retorna o elemento removido
    }

    public static void main(String[] args) {
        Queue queue = new Queue(2);
        queue.getFirst();
        queue.getLast();
        queue.getLength();
        queue.print();

        queue.enqueue(10);
        queue.enqueue(20);

        queue.getFirst();
        queue.getLast();
        queue.getLength();
        queue.print();
    }
}
