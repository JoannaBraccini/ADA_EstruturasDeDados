package dataStructure;

import java.util.Scanner;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    // A lista ligada é composta de nós (nodes)
    public static class Node {
        String data; // Cada nó armazena informação
        Node next; // Cada nó aponta para o próximo

        public Node(String data) {
            this.data = data;
        }

        public String getData() { return data; }
    }

    public LinkedList(String data) {
        length = 1;
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
    }

    public void getHead() {
        if (this.head == null) {
            System.out.println("Lista vazia");
        } else {
            System.out.println("Head: " + head.data);
        }
    }

    public void getTail() {
        if (this.tail == null) {
            System.out.println("Lista vazia");
        } else {
            System.out.println("Tail: " + tail.data);
        }
    }

    public void getLength() {
        System.out.println( "Length: " + this.length);
    }

    public void makeEmpty() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void print(){
        if (this.head == null) {
            System.out.println("Lista vazia");
            return;
        }
        Node temp = this.head;
        while(temp != null){
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Insere um novo elemento no final da lista (append).
    public void append(String data){
        // Cria um nó com os dados fornecidos
        Node newNode = new Node(data);
        // Caso especial: se a lista está vazia (length == 0)
        // o novo nó será tanto a cabeça quanto a cauda
        if (length == 0) head = newNode;
        // Caso geral: lista já possui elementos
        // Conecta o antigo último elemento (tail) ao novo nó
        else tail.next = newNode;
        // Atualiza a cauda da lista para apontar para o novo nó
        // Isso torna o novo nó o último elemento da lista
        tail = newNode;
        // Incrementa o contador de elementos da lista
        length++;
    }

    // Remove e retorna o último elemento da lista.
    public Node removeLast() {
        // Caso especial: lista vazia
        // Não há nada para remover, retorna null
        if (length == 0) return null;
        // Inicializa um nó "leitor" que percorrerá a lista
        // começando pela cabeça
        Node leitor = head;
        // Variável para armazenar o nó que será removido e retornado
        Node temp = null;
        // Percorre a lista até encontrar o penúltimo nó
        // O penúltimo nó é aquele cujo próximo (next) aponta para a cauda (tail)
        // Precisamos dele para atualizar a nova cauda
        while (leitor.next != tail) {
            leitor = leitor.next;
        }
        // Guarda referência ao nó atual da cauda (último elemento)
        // para ser retornado no final
        temp = tail;
        // Atualiza a cauda para o penúltimo nó (onde o leitor parou)
        tail = leitor;
        // Remove a ligação do novo último nó para o antigo último
        // Isso efetivamente remove o último elemento da lista
        tail.next = null;
        // Decrementa o contador de elementos
        length--;
        // Caso especial: após a remoção, a lista ficou vazia
        // Ambos head e tail devem apontar para null
        if (length == 0) {
            head = null;
            tail = null;
        }
        // Retorna o nó removido
        return temp;
    }
    
    // Insere um novo elemento no início da lista (prepend).
    public void prepend(String data){
        // Cria um nó com os dados fornecidos
        Node newNode = new Node(data);
        // Caso especial: se a lista está vazia
        // o novo nó será tanto a cabeça quanto a cauda
        if(length == 0) tail = newNode;
            // Caso geral: lista já possui elementos
            // O novo nó deve apontar para o antigo primeiro elemento
        else newNode.next = head;
        // Atualiza a cabeça da lista para apontar para o novo nó
        // Isso torna o novo nó o primeiro elemento da lista
        head = newNode;
        // Incrementa o contador de elementos da lista
        length++;
    }

    public Node removeFirst(){
        // Caso especial: lista vazia
        // Não há nada para remover, retorna null
        if (length == 0) return null;
        // Guarda referência ao primeiro nó (cabeça) que será removido
        // para ser retornado no final
        Node temp = head;
        // Atualiza a cabeça para o segundo elemento da lista
        // O primeiro nó agora está "desconectado" da lista
        head = head.next;
        // Remove a ligação do nó removido para o próximo elemento
        // Isso é uma boa prática para evitar referências desnecessárias
        temp.next = null;
        // Decrementa o contador de elementos
        length--;
        // Caso especial: após a remoção, a lista ficou vazia
        // Ambos head e tail devem apontar para null
        if (length == 0) {
            head = null;
            tail = null;
        }
        // Retorna o nó removido
        return temp;
    }

    // Retorna o nó na posição especificada pelo índice.
    public Node get(int index) {
        // Validação: verifica se o índice está dentro dos limites válidos
        // Índice deve ser ≥ 0 e < length (tamanho da lista)
        if (index < 0 || index >= length) return null;
        // Inicializa um nó "leitor" que percorrerá a lista
        // começando pela cabeça
        Node temp = head;
        // Percorre a lista até alcançar a posição desejada
        // A cada iteração, avança para o próximo nó
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        // Retorna o nó encontrado na posição especificada
        return temp;
    }

    // Insere um novo elemento numa posição específica da lista.
    public boolean insert(int index, String data) {
        // Validação: verifica se o índice está dentro dos limites válidos
        // Índice deve ser ≥ 0 e ≤ length (pode inserir no final)
        if (index < 0 || index > length) return false;
        // Caso especial: inserção no início da lista (índice 0)
        // Reutiliza o método prepend() e retorna true (sucesso)
        if (index == 0) {
            prepend(data);
            return true;
        }
        // Caso especial: inserção no final da lista
        // Reutiliza o método append() e retorna true (sucesso)
        if (index == length) {
            append(data);
            return true;
        }
        // Caso geral: inserção no meio da lista
        // Cria um nó com os dados fornecidos
        Node newNode = new Node(data);
        // Obtém o nó que está na posição anterior ao índice desejado
        // Precisamos dele para fazer a ligação correta
        Node temp = get(index - 1);
        // Conecta o novo nó ao nó que estava na posição do índice
        // O novo nó agora aponta para o próximo elemento
        newNode.next = temp.next;
        // Conecta o nó anterior ao novo nó
        // Isso insere o novo nó na posição desejada
        temp.next = newNode;
        // Incrementa o contador de elementos
        length++;
        // Retorna true indicando sucesso na inserção
        return true;
    }

    // Atualiza o valor de um nó numa posição específica da lista.
    public boolean set(int index, String data) {
        // Tenta obter o nó na posição especificada pelo índice
        // O método get() já valida se o índice é válido
        Node temp = get(index);
        // Se o nó não foi encontrado (índice inválido), retorna false
        if (temp == null) return false;
        // Atualiza o dado armazenado no nó encontrado
        temp.data = data;
        // Retorna true indicando sucesso na atualização
        return true;
    }

    // Remove e retorna o nó numa posição específica da lista.
    public Node remove(int index){
        // Validação: verifica se o índice está dentro dos limites válidos
        // Índice deve ser ≥ 0 e < length (tamanho da lista)
        if (index < 0 || index >= length) return null;
        // Caso especial: remoção no início da lista (índice 0)
        // Reutiliza o método removeFirst() que é otimizado para esta operação
        if (index == 0) return removeFirst();
        // Caso especial: remoção no final da lista
        // Reutiliza o método removeLast() que é otimizado para esta operação
        if (index == length - 1) return removeLast();
        // Caso geral: remoção no meio da lista
        // Obtém o nó que está na posição anterior ao índice que será removido
        // Precisamos dele para fazer a reconexão dos ponteiros
        Node prev = get(index - 1);
        // Guarda referência ao nó que será removido
        // Este é o nó que está na posição do índice especificado
        Node temp = prev.next;
        // Conecta o nó anterior diretamente ao próximo nó
        // Isso "pula" o nó que será removido, desconectando-o da lista
        prev.next = temp.next;
        // Remove a ligação do nó removido para o próximo elemento
        // Isso é uma boa prática para liberar memória e evitar referências soltas
        temp.next = null;
        // Decrementa o contador de elementos da lista
        length--;
        // Retorna o nó removido
        return temp;
    }

    // Menu interativo para o usuário
    private static void menu() {
        System.out.println("=== Lista Encadeada - Menu Interativo ===");
        System.out.println("1. Adicionar elemento no final (append)");
        System.out.println("2. Adicionar elemento no início (prepend)");
        System.out.println("3. Remover último elemento (removeLast)");
        System.out.println("4. Remover primeiro elemento (removeFirst)");
        System.out.println("5. Inserir elemento em posição específica (insert)");
        System.out.println("6. Remover elemento de posição específica (remove)");
        System.out.println("7. Atualizar elemento de posição específica (set)");
        System.out.println("8. Exibir elemento de posição específica (get)");
        System.out.println("9. Exibir cabeça da lista (getHead)");
        System.out.println("10. Exibir cauda da lista (getTail)");
        System.out.println("11. Exibir tamanho da lista (getLength)");
        System.out.println("12. Esvaziar lista (makeEmpty)");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList("Primeiro");

        int opcao;
        do {
            menu();
            // Leitura robusta da opção do usuário
            while (!scanner.hasNextInt()) {
                System.out.println("Opção inválida. Digite um número entre 0 e 12.");
                scanner.next(); // Descarta a entrada inválida
            }
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o dado para o novo elemento: ");
                    list.append(scanner.next());
                    break;
                case 2:
                    System.out.print("Digite o dado para o novo elemento: ");
                    list.prepend(scanner.next());
                    break;
                case 3:
                    Node noRemovido = list.removeLast();
                    if (noRemovido != null) {
                        System.out.println("Elemento removido: " + noRemovido.data);
                    } else {
                        System.out.println("A lista já está vazia.");
                    }
                    break;
                case 4:
                    noRemovido = list.removeFirst();
                    if (noRemovido != null) {
                        System.out.println("Elemento removido: " + noRemovido.data);
                    } else {
                        System.out.println("A lista já está vazia.");
                    }
                    break;
                case 5:
                    System.out.print("Digite o índice para inserção: ");
                    int indiceInsercao = scanner.nextInt();
                    System.out.print("Digite o dado para o novo elemento: ");
                    if (list.insert(indiceInsercao, scanner.next())) {
                        System.out.println("Elemento inserido com sucesso.");
                    } else {
                        System.out.println("Erro na inserção. Verifique o índice.");
                    }
                    break;
                case 6:
                    System.out.print("Digite o índice do elemento a ser removido: ");
                    int indiceRemocao = scanner.nextInt();
                    Node noRemovidoEspecifico = list.remove(indiceRemocao);
                    if (noRemovidoEspecifico != null) {
                        System.out.println("Elemento removido: " + noRemovidoEspecifico.data);
                    } else {
                        System.out.println("Erro na remoção. Verifique o índice.");
                    }
                    break;
                case 7:
                    System.out.print("Digite o índice do elemento a ser atualizado: ");
                    int indiceAtualizacao = scanner.nextInt();
                    System.out.print("Digite o novo dado: ");
                    if (list.set(indiceAtualizacao, scanner.next())) {
                        System.out.println("Elemento atualizado com sucesso.");
                    } else {
                        System.out.println("Erro na atualização. Verifique o índice.");
                    }
                    break;
                case 8:
                    System.out.print("Digite o índice do elemento a ser exibido: ");
                    int indiceExibicao = scanner.nextInt();
                    Node noExibido = list.get(indiceExibicao);
                    if (noExibido != null) {
                        System.out.println("Elemento no índice " + indiceExibicao + ": " + noExibido.data);
                    } else {
                        System.out.println("Elemento não encontrado nesse índice.");
                    }
                    break;
                case 9:
                    list.getHead();
                    break;
                case 10:
                    list.getTail();
                    break;
                case 11:
                    list.getLength();
                    break;
                case 12:
                    list.makeEmpty();
                    System.out.println("Lista esvaziada.");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Digite um número entre 0 e 12.");
            }

            System.out.println(); // Linha em branco para separar as operações

        } while (opcao != 0);

        scanner.close();
    }
}
