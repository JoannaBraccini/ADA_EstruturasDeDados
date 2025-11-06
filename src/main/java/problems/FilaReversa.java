/*
 * Problema:
 * Revertendo os primeiros K elementos de uma fila
 *
 * Dado um inteiro k e uma fila de inteiros, a tarefa é inverter a ordem dos primeiros k elementos da fila, deixando os demais elementos na mesma ordem relativa
 *
 * [1, 2, 3, 4, 5] -> K = 2 -> [2, 1, 3, 4, 5]
 * [1, 2, 3, 4, 5] -> K = 4 -> [4, 3, 2, 1, 5]
 *
 * Algoritmo:
 * 1 - Para os k primeiros elementos:
 *   1 - desenfileirar elemento x
 *   2 - reordenar (k-1) elementos
 *   3 - enfileirar elemento x
 * 2 - Para os N-K elementos:
 *   1 - desenfileirar
 *   2 - enfileirar
 *
 * queue = [1, 2, 3, 4, 5], K = 4
 * x = 1, ([2,3,4,5], 3)
 * x = 2, ([3,4,5], 2)
 * x = 3, ([4,5], 1)
 * x = 4, ([5], 0)
 * queue = [4, 3, 2, 1, 5]
 * */
package problems;

import java.util.LinkedList;
import java.util.Queue;

public class FilaReversa {

    public static Queue<Integer> reverseFirstK(Queue<Integer> queue, int k) {
        solveQueue(queue, k);
        int n = queue.size() - k;
        // Enquanto houver elementos para reordenar
        while (n-- > 0) {
            // Desenfileira o primeiro elemento da fila
            int element = queue.remove();
            // Enfileira o elemento lido, colocando no final da fila
            queue.add(element);
        }
        return queue;
    }

    private static void solveQueue(final Queue<Integer> queue, final int k) {
        if (k == 0 || queue.isEmpty()) return;
        // Lê o primeiro elemento da fila e desenfileira
        int element = queue.remove();
        // Resolve a fila para os k-1 elementos restantes
        solveQueue(queue, k - 1);
        // Enfileira o elemento lido, colocando no final da fila
        queue.add(element);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println("Queue: " + queue); // [1, 2, 3, 4, 5]
        System.out.println("Reversed queue: " + reverseFirstK(queue, 4)); // [4, 3, 2, 1, 5]
    }
}
