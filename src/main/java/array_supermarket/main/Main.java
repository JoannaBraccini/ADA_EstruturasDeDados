package array_supermarket.main;

import array_supermarket.implementation.Supermarket;
import array_supermarket.implementation.SupermarketArray;

import java.util.Scanner;

public class Main {
    private static final int SIZE = 3;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Supermarket supermarket = new SupermarketArray(SIZE);
        int option;

        do {
            System.out.println("\nLista de Compras");
            System.out.println("1 - Inserir");
            System.out.println("2 - Listar");
            System.out.println("3 - Remover");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");

            // proteger contra EOF/entrada inválida
            if (!scanner.hasNext()) {
                System.out.println("\nEntrada encerrada. Saindo...");
                break;
            }
            while (!scanner.hasNextInt()) {
                if (!scanner.hasNext()) {
                    System.out.println("\nEntrada encerrada. Saindo...");
                    scanner.close();
                    return;
                }
                System.out.print("Digite um número válido: ");
                scanner.next();
            }

            option = scanner.nextInt();
            if (scanner.hasNextLine()) scanner.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.println("Digite o nome do item: ");
                    String item = scanner.hasNextLine() ? scanner.nextLine() : "";
                    supermarket.add(item);
                }
                case 2 -> supermarket.print();
                case 3 -> {
                    // Mostra a lista atual para que o usuário veja as posições (1-based)
                    supermarket.print();

                    System.out.println("Digite a posição do item a ser removido: ");
                    if (!scanner.hasNext()) {
                        System.out.println("Entrada encerrada durante leitura do índice. Saindo...");
                        scanner.close();
                        return;
                    }
                    while (!scanner.hasNextInt()) {
                        if (!scanner.hasNext()) {
                            System.out.println("Entrada encerrada durante leitura do índice. Saindo...");
                            scanner.close();
                            return;
                        }
                        System.out.print("Digite um número válido para posição: ");
                        scanner.next();
                    }
                    int userPos = scanner.nextInt();
                    if (scanner.hasNextLine()) scanner.nextLine();
                    int index = userPos - 1; // converter para 0-based interno
                    boolean removed = supermarket.delete(index);
                    if (removed) System.out.println("Item removido com sucesso.");
                    else System.out.println("Posição inválida. Nenhuma remoção realizada.");
                }
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida. Por favor, tente novamente");
            }
        } while (option != 0);

        scanner.close();
    }
}
