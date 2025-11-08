# EstruturasDeDados — Guia rápido para estudantes

[![Ada — Elas + Tech](https://img.shields.io/badge/Ada-ELAS%20%2B%20TECH-purple?style=flat-square)](https://ada.tech) [![LinkedIn](https://img.shields.io/badge/LinkedIn-joannabraccini-blue?logo=linkedin&style=flat-square)](https://www.linkedin.com/in/joannabraccini)

**Nota:** Estas aulas fazem parte do programa *Ada — Elas + Tech*. Aqui estão exemplos simples de estruturas de dados em Java (listas, pilhas, filas, árvores etc.) pensados para estudo e prática. O repositório foi reorganizado como uma coleção de pastas de aula independentes; cada pasta de aula pode ter seu próprio `Main` quando necessário.

---

## Sumário
- [Começar rápido](#come%C3%A7ar-r%C3%A1pido)
- [O que tem neste repositório](#o-que-tem-neste-reposit%C3%B3rio)
- [Descrição dos arquivos](#descri%C3%A7%C3%A3o-dos-arquivos)
- [Verificação: ordem de inserção nas árvores](#verifica%C3%A7%C3%A3o-ordem-de-inser%C3%A7%C3%A3o-nas-%C3%A1rvores)
- [Refatorações e melhorias sugeridas](#refatora%C3%A7%C3%B5es-e-melhorias-sugeridas)
- [Complexidade — explicação rápida](#complexidade---explica%C3%A7%C3%A3o-r%C3%A1pida)
- [Como usar — passos e exemplos](#como-usar---passos-e-exemplos)
- [Contato](#contato)

---

## Começar rápido
1. Abra um terminal na pasta do projeto.
2. Compile o projeto (sem testes):

```cmd
mvn -DskipTests package
```

3. Rodar exemplos/samples: alguns subdiretórios têm a própria classe `Main` para executar exemplos (por exemplo `array_supermarket/main/Main.java`). Após compilar, execute a classe desejada a partir de `target/classes`.

Exemplo (Windows/cmd.exe) — executar o `Main` em `array_supermarket.main`:

```cmd
java -cp target\classes array_supermarket.main.Main
```

---

## O que tem neste repositório
- `src/main/java/dataStructure` — implementações das estruturas (por ex. `LinkedList.java`, `Stack.java`, `Queue.java`, `Tree.java`, `BinarySearchTree.java`) com comentários e exemplos.
- `src/main/java/array_supermarket` — exemplo didático de uma lista de compras sobre um array fixo (`SupermarketArray`) com um `Main` para interação.
- `src/main/java/FilaDeAtendimento.java` — exemplo que usa a `Queue` para simular atendimento ao cliente (pequena simulação/runner).

---

## Descrição dos arquivos
Abaixo há uma descrição mais detalhada dos arquivos principais do repositório e o que cada um ilustra — use como referência rápida para estudar e propor exercícios entre colegas.

### `src/main/java/dataStructure/LinkedList.java`
- O que é: Implementação de uma lista simplesmente encadeada (singly linked list) com operações básicas.
- O que ilustra: nós (`Node`), referências (`next`), operações append/prepend, removeFirst/removeLast, get/insert/remove por índice, atualização (set), e um menu interativo para testar as operações.
- Observação prática: o método `removeLast()` tinha um caso-limite em que a lista com 1 elemento não era tratado corretamente — isso foi corrigido.

### `src/main/java/dataStructure/Stack.java`
- O que é: Pilha (Stack) implementada via nós encadeados.
- O que ilustra: comportamento LIFO (Last-In, First-Out), operações `push` e `pop`, inspeção do topo (`getTop`) e altura (`getHeight`).

### `src/main/java/dataStructure/Queue.java`
- O que é: Fila (Queue) implementada via nós encadeados.
- O que ilustra: comportamento FIFO (First-In, First-Out), operações `enqueue` e `dequeue`, e impressão/inspeção dos elementos.
- Uso prático: pode ser usada para simulações simples (por exemplo em `FilaDeAtendimento`).

### `src/main/java/dataStructure/Tree.java`
- O que é: Árvore binária genérica (não ordenada) com inserção por nível (preenche a árvore da esquerda para a direita).
- O que ilustra: definição de nó de árvore, inserção por nível usando uma fila auxiliar, percursos pré-ordem/in-ordem/pós-ordem, BFS (busca em largura) e noções de árvores cheias/completas/perfeitas.
- Observação: essa estrutura preenche por nível; se você quiser uma BST (ordenada), use `BinarySearchTree`.

### `src/main/java/dataStructure/BinarySearchTree.java`
- O que é: Árvore Binária de Busca (BST) com operações de `insert`, `contains`, `delete` e `inOrder`.
- O que ilustra: propriedade BST (filhos à esquerda menores, à direita maiores), pesquisa eficiente (complexidade média O(log n)), remoção com os três casos (folha, um filho, dois filhos) e uso de `minValue` para substituir nós com dois filhos.
- Observação prática: o `main` nesta classe insere valores na ordem que gera a configuração usada em exemplos (raiz 37; 11 à esquerda; 66 à direita; 8 e 17 sob 11; etc.).

---

## `src/main/java/array_supermarket`

### `src/main/java/array_supermarket/implementation/Supermarket.java`
- Interface que define a API mínima (contrato) de um supermercado/lista de compras (métodos `add`, `print`, `delete`).

### `src/main/java/array_supermarket/implementation/SupermarketArray.java`
- O que é: Implementação da interface `Supermarket` usando um array fixo.
- O que ilustra: manipulação de arrays, controle de índice (`lastIndex`), verificação de overflow (lista cheia) e custo de operações (ex.: `delete` exige deslocamento — O(n)).
- Nota de UX: o `Main` mostra posições 1..n para o usuário (mais amigável) e converte para índice 0-based internamente ao chamar `delete`. O método `delete` agora retorna `boolean` (true se a remoção foi bem-sucedida) — o `Main` exibe uma mensagem apropriada de sucesso/erro.

### `src/main/java/array_supermarket/main/Main.java`
- O que é: `Main` interativo que permite inserir, listar e remover itens da `SupermarketArray` via terminal.
- O que ilustra: uso de `Scanner`, validação de entrada e integração com a implementação concreta. Agora o `Main` mostra a lista antes de pedir a posição para remoção (para evitar confusão com índices).

---

### `src/main/java/app/FilaDeAtendimento.java`
- O que é: Runner que simula um sistema simples de atendimento ao cliente usando a classe `Queue` (gera números aleatórios para clientes e os atende em ordem FIFO).
- Observação: agora está em `package app` (melhor do que o pacote padrão).

---

## Verificação: ordem de inserção nas árvores
(Opcional) Se quiser reproduzir a árvore do enunciado, use `BinarySearchTree` — o `main` já insere os valores na ordem que gera a estrutura desejada (raiz 37; 11 à esquerda; 66 à direita; 8 e 17 sob 11; 42 e 72 sob 66).

---

## Refatorações e melhorias sugeridas (ideias entre colegas)
- Transformar as estruturas em genéricas (`LinkedList<T>`, `Stack<T>`, `Queue<T>`) para praticar Generics.
- Adicionar testes unitários (JUnit) para casos de borda: listas vazias, remoção em listas com 1 elemento, remoção de nó com dois filhos em BST, etc.

---

## Complexidade — explicação rápida (Big-O)
- LinkedList (singly):
  - append/prepend: O(1)
  - get(index): O(n)
  - removeLast (se não há ponteiro para prev): O(n)
- Stack (linked):
  - push/pop: O(1)
- Queue (linked):
  - enqueue/dequeue: O(1)
- BinarySearchTree (balanceada idealmente):
  - search/insert/delete: O(log n) em média
  - no pior caso: O(n)
- Tree traversals (in/pre/post/BFS): O(n) tempo e O(h) espaço (h = altura)

Dica rápida: vale notar a diferença entre comportamento médio e pior caso — a forma da árvore afeta muito o desempenho da BST.

---

## Como usar — passos e exemplos
Execute os `Main`s nas pastas de exemplo ou crie pequenos runners/testes para experimentar as estruturas.

### Exemplo rápido — executar `BinarySearchTree.main` compilado:

```cmd
mvn -DskipTests package
java -cp target\classes dataStructure.BinarySearchTree
```

### Exemplo rápido — executar `array_supermarket`:

```cmd
mvn -DskipTests package
java -cp target\classes array_supermarket.main.Main
```

---

## Ideias para continuar
- Corrigir/refatorar `removeLast()` (já ajustado) e converter estruturas para `Generics`.
- Escrever testes unitários rápidos para as operações básicas.
- Mover/simplificar runners conforme preferir (já movemos `FilaDeAtendimento` para `app`).

---

## Contato
Se quiser trocar ideias ou colaborar:

- LinkedIn: https://www.linkedin.com/in/joannabraccini

---

(README atualizado em 2025-11-08)
