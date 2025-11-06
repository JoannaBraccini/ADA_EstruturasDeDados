/*
Balanceamento de parênteses em uma expressão

Dada uma string de expressão exp, escreva um programa para examinar se os pares e as ordens de "{", "}", "(", ")", "[", "]" estão corretos na expressão dada.

2*(3+4+5*[2+3)]
2*(3+4+5*[2+3])
[2*(3+4+5*[2+3]/(2+(3+(7+5)*9)*6)*[5+8]+17)+2]

Solução: uso de pilhas
1 - Empilhar caracteres de abertura
2 - Ao identificar caracter de fechamento:
    - Desempilhar e verificar se coincide com abertura
3 - Ao final a pilha deve estar vazia
*/

package problems;

import java.util.Set;
import java.util.Stack;

public class BalanceamentoDeParenteses {

    public static boolean solve(String expression) {
        // se a string for nula ou vazia retorna true
        if (expression == null || expression.isEmpty()) return true;
        // cria conjunto para armazenar os caracteres de abertura
        Set<Character> openBrackets = Set.of('{', '[', '(');
        // cria conjunto para armazenar os caracteres de fechamento
        Set<Character> closeBrackets = Set.of('}', ']', ')');
        // cria pilha para armazenar os caracteres
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            // se o caracter for abertura empilha no topo da pilha
            if (openBrackets.contains(c)) stack.push(c);
            // se o caracter for fechamento
            if (closeBrackets.contains(c)) {
                // se a pilha estiver vazia retorna false
                if (stack.isEmpty()) return false;
                var open = stack.pop();
                if (open == '(' && c != ')') return false;
                if (open == '[' && c != ']') return false;
                if (open == '{' && c != '}') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(solve("2*(3+4+5*[2+3)]")); // false
        System.out.println(solve("[2*(3+4+5*[2+3]/(2+(3+(7+5)*9)*6)*[5+8]+17)+2]")); // true
        System.out.println(solve("2*(3+4+5*[2+3])")); // true
    }
}