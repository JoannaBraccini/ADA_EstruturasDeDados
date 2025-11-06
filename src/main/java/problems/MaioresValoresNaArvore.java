
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
import java.util.List;

public class MaioresValoresNaArvore {

    public  static List<Integer> largestValues(Tree tree) {
        var list = new ArrayList<Integer>();
        solveTree(tree.root, 0, list);
        return list;
    }

    private static void solveTree(final Tree.Node node, final int level, final ArrayList<Integer> list) {

        if (node == null) return;
        // Se o nível for igual ao tamanho da lista, adiciona o valor
        if (level == list.size()) list.add(node.value);
        // Senão, atualiza o valor máximo
        else list.set(level, Math.max(list.get(level), node.value));
        // Recursivamente percorre os filhos
        solveTree(node.left, level + 1, list);
        solveTree(node.right, level + 1, list);
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(100);

        tree.insert(10);
        tree.insert(5);

        tree.insert(6);
        tree.insert(1);
        tree.insert(7);
        tree.insert(5);

        System.out.println(largestValues(tree)); // [100, 10, 7]
    }
}
