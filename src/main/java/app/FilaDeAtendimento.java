package app;

import dataStructure.Queue;

import java.util.Random;

public class FilaDeAtendimento {
    public static void main(String[] args) {
        int n = 5;
        var random = new Random();
        int cliente = random.nextInt(101);
        Queue fila = new Queue(cliente);
        // Desafio fila de atendimento
        System.out.println();
        System.out.println("==== Sistema de atendimento ao cliente ====");
        // Simula a entrada de n-1 clientes na fila
        System.out.println("Cliente " + cliente + " entrou na fila.");
        for (int i = 2; i <= n; i++) {
            cliente = random.nextInt(101);
            System.out.println("Cliente " + cliente + " entrou na fila.");
            fila.enqueue(cliente);
        }

        // Atendimento dos clientes
        var node = fila.dequeue();
        while (node != null) {
            System.out.println("Cliente " + node.getValue() + " foi atendido.");
            node = fila.dequeue();
        }
    }
}

