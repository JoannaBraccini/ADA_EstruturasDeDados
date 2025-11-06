# EstruturasDeDados — Guia rápido para estudantes

[![Ada — Elas + Tech](https://img.shields.io/badge/Ada-ELAS%20%2B%20TECH-purple?style=flat-square)](https://ada.tech) [![LinkedIn](https://img.shields.io/badge/LinkedIn-joannabraccini-blue?logo=linkedin&style=flat-square)](https://www.linkedin.com/in/joannabraccini)

**Nota:** Estas aulas fazem parte do programa *Ada — Elas + Tech*. Aqui estão exemplos simples de estruturas de dados em Java (listas, pilhas, filas etc.) pensados para você estudar e praticar. O repositório agora contém as implementações e pastas de aula; os CLIs interativos e o launcher global foram removidos — cada pasta de aula pode ter seu próprio `Main` quando aplicável.

---

## Sumário
- [Começar rápido](#come%C3%A7ar-r%C3%A1pido)
- [O que tem neste repositório](#o-que-tem-neste-reposit%C3%B3rio)
- [Descrição dos arquivos](#descri%C3%A7%C3%A3o-dos-arquivos)
- [Como usar — passos e exemplos](#como-usar---passos-e-exemplos)
  - [Exemplo: Listas encadeadas](#exemplo-listas-encadeadas)
  - [Exemplo: Pilhas (Stack)](#exemplo-pilhas-stack)
- [Dicas para estudar](#dicas-para-estudar)
- [Problemas comuns](#problemas-comuns)
- [Contato](#contato)

---

## Começar rápido
1. Abra um terminal na pasta do projeto.
2. Compile o projeto (sem testes):

```cmd
mvn -DskipTests package
```

3. Rodar exemplos/samples: alguns subdiretórios possuem a própria classe `Main` para execução de exemplos (por exemplo `array_supermarket/main/Main.java`). Para executar uma classe `Main` específica após compilar, use o nome completo da classe (se houver) ou execute a classe compilada a partir de `target/classes`.

Exemplo (Windows/cmd.exe) — executar o `Main` em `array_supermarket.main`:

```cmd
java -cp target\classes array_supermarket.main.Main
```

Se uma pasta de aula não tem `Main`, você pode criar um pequeno `Main` local para testar a estrutura ou escrever testes unitários.

---

## O que tem neste repositório
- `dataStructure` — implementações das estruturas (por ex. `LinkedList.java`, `Stack.java`, `Queue.java`, `Tree.java`, `BinarySearchTree.java`) com comentários e exemplos.
- `array_supermarket` — exemplo didático de uma lista de compras implementada sobre um array fixo (`SupermarketArray`) com um `Main` para interação.
- `FilaDeAtendimento.java` — exemplo independente que usa a `Queue` para simular atendimento ao cliente (pequena simulação/runner).
- Subpastas de aula podem conter seus próprios `Main` para rodar exemplos isolados.

> Observação: os CLIs interativos (`src/main/java/cli`) e o launcher global (`src/main/java/Main.java`) foram removidos; o repositório é tratado como coleção de exemplos e material de aula, sem entrypoint único.

---

## Descrição dos arquivos
Abaixo há uma breve descrição dos arquivos principais do repositório e qual conceito de aula eles ilustram.

### `src/main/java/dataStructure/LinkedList.java`
- O que é: Implementação de uma lista simplesmente encadeada com operações básicas.
- O que demonstra: conceitos de nós (`Node`), referências (`next`), inserção/remover no início/fim/meio, acesso por índice, e complexidade (por que operações se comportam como O(1) ou O(n)).

### `src/main/java/dataStructure/Stack.java`
- O que é: Pilha (Stack) implementada via nós encadeados.
- O que demonstra: comportamento LIFO (Last-In, First-Out), operações `push` e `pop`, e noções de estado (topo, altura). Útil para entender chamadas de função/recursão e estruturas auxiliares.

### `src/main/java/dataStructure/Queue.java`
- O que é: Fila (Queue) implementada via nós encadeados.
- O que demonstra: comportamento FIFO (First-In, First-Out), operações `enqueue` e `dequeue`, e uso em simulações (por exemplo, `FilaDeAtendimento`).

### `src/main/java/dataStructure/Tree.java`
- O que é: Árvore binária (estrutura geral, não necessariamente ordenada) com inserção por nível.
- O que demonstra: definição de nós de árvore, inserção nível-a-nível, e diferentes percursos (pré-ordem, em-ordem, pós-ordem), além de BFS (busca em largura) e noções de completude/cheia/perfeita.

### `src/main/java/dataStructure/BinarySearchTree.java`
- O que é: Árvore Binária de Busca (BST) com operações de `insert`, `contains`, `delete` e `inOrder`.
- O que demonstra: propriedade BST (filhos à esquerda menores, à direita maiores), pesquisa eficiente (complexidade média O(log n)), remoção com os três casos (folha, um filho, dois filhos) e como usar `minValue` para substituir nós quando necessário.

### `src/main/java/array_supermarket/implementation/Supermarket.java`
- O que é: Interface que define a API mínima de um supermercado/lista de compras (métodos `add`, `print`, `delete`).
- O que demonstra: uso de interfaces para definir contratos de implementação.

### `src/main/java/array_supermarket/implementation/SupermarketArray.java`
- O que é: Implementação da interface `Supermarket` usando um array fixo.
- O que demonstra: manipulação de arrays, controle de índice (`lastIndex`), custo de operações (ex.: `delete` exige deslocamento de elementos — O(n)), checagem de limites e tratamento de lista cheia.

### `src/main/java/array_supermarket/main/Main.java`
- O que é: Pequeno `Main` interativo que permite inserir, listar e remover itens da `SupermarketArray` via terminal.
- O que demonstra: entrada/saída via `Scanner`, validação básica de entrada, e integração de uma implementação concreta com uma interface.

### `src/main/java/FilaDeAtendimento.java`
- O que é: Runner independente que simula um sistema simples de atendimento ao cliente usando a classe `Queue`.
- O que demonstra: modelagem de filas no mundo real, uso de números aleatórios para simular clientes, e consumo sequencial (dequeue) até a fila ficar vazia.

---

## Como usar — passos e exemplos
Execute os `Main`s presentes nas pastas de exemplo, ou escreva pequenos runners/testes para experimentar as estruturas.

### Exemplo: Listas encadeadas
1. Compile o projeto:

```cmd
mvn -DskipTests package
```

2. Se existir um `Main` de exemplo para listas (nem sempre há), execute-o com `java -cp target\classes <fully.qualified.MainClass>`; caso contrário, adicione um `Main` temporário em `src/main/java` ou crie um teste para exercitar a `LinkedList`.

Sequência de teste rápida (exemplo hipotético):
```
// crie um pequeno Main que use LinkedList e execute
```

### Exemplo: Pilhas (Stack)
Mesmo procedimento: compile e execute um `Main` de exemplo se disponível, ou crie um runner local.

---

## Dicas para estudar
- Leia os arquivos em `src/main/java/dataStructure/` — cada método tem comentários explicando a lógica.
- Experimente alterar o código (por exemplo, trocar a ordem de pushes) e veja o que muda.
- Transforme um exemplo em exercício: comente um trecho do `main` (ou crie um) e implemente você mesmo a funcionalidade.

---

## Problemas comuns
- Erro ao rodar `mvn clean` (não consegue deletar JAR): verifique se há alguma JVM em execução que esteja usando o JAR. Feche programas/IDE ou reinicie.

---

## Contato
Se quiser trocar ideias ou colaborar:

- LinkedIn: https://www.linkedin.com/in/joannabraccini

---
