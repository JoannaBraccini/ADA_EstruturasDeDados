
/*
 * Problema:
 * Maior valor em cada nível da Árvore Binária
 *
 * Dada uma árvore binária, encontre o maior valor em cada nível
 *
 *     37
 *  11    66
 * 8 17 42 72
 *
 * Resultado esperado: 37, 66, 72
 *
 * Algoritmo:
 *
 * 1 - Utilize o algoritmo BFS (Busca em Largura) para percorrer a árvore e uma lista auxiliar
 * 2 - Para cada elemento e seu nível na árvore:
 *   1 - Se a lista possuir o índice == nível, substitua pelo maior valor
 *   2 - Senão, adicione na lista
 * */
package problems;

import dataStructure.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaiorValorBFS {

    /* percorre a árvore por níveis (BFS) e, para cada nível,
    * calcula o maior valor dos nós desse nível e
    * adiciona à lista resultado.*/
    public static List<Integer> largestValues(Tree.Node root) {
        List<Integer> result = new ArrayList<>();
        /* Entrada e caso base
        Recebe o nó root (Tree.Node).
        Se root == null retorna uma lista vazia.*/
        if (root == null) return result;

        /*Estrutura de suporte
        Cria uma fila (Queue<Tree.Node>) e adiciona root.
        A fila mantém os nós do nível atual e dos próximos níveis.*/
        Queue<Tree.Node> fila = new LinkedList<>();
        fila.add(root);

        /* Loop por níveis
        Enquanto a fila não estiver vazia:*/
        while (!fila.isEmpty()) {
//            Capture level = fila.size() — número de nós no nível atual.
            int level = fila.size();
//            Inicialize max = Integer.MIN_VALUE para rastrear o maior valor desse nível.
            int max = Integer.MIN_VALUE;

            /*Processamento dos nós do nível
            Faça um loop de 0 até level - 1:*/
            for (int i = 0; i < level; i++) {
                Tree.Node node = fila.remove(); // Remova um nó da fila
                if (node.value > max) max = node.value; // Atualize max se node.value > max.
                if (node.left != null) fila.add(node.left); // Se node.left != null adicione node.left à fila.
                if (node.right != null) fila.add(node.right); // Se node.right != null adicione node.right à fila.
            }
            result.add(max); // Ao terminar o loop do nível, acrescente max em result.
        }

        /*Finalização
        Quando todos os níveis forem processados (fila vazia),
        retorne a lista result com um elemento por nível (maior valor).*/
        return result;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(37); // raiz
        tree.insert(11); // 1º filho
        tree.insert(66); // 2º filho
        tree.insert(8); // 1º neto
        tree.insert(17); // 2º neto
        tree.insert(42); // 3º neto
        tree.insert(72); // 4º neto

        List<Integer> maiores = MaiorValorBFS.largestValues(tree.root);
        System.out.println(maiores); // Deve imprimir [37, 66, 72]
    }
}
