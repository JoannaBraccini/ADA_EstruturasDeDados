package array_supermarket.implementation;

public class SupermarketArray implements Supermarket {

    private final String[] items;
    private int lastIndex;

    public SupermarketArray(final int size) {
        items = new String[size];
        lastIndex = -1;
    }


    @Override
    public void add(String item) {
        if(lastIndex == items.length-1){
            System.err.println("Lista de Supermercado está cheia");
        } else {
            items[++lastIndex] = item; // O mesmo que lastIndex++; items[lastIndex] = item;
        }
    }

    @Override
    public void print() {
        System.out.println("===============================");
        if (lastIndex == -1){
            System.out.println("Lista de Supermercado vazia");
        }
        for (int i = 0; i <= lastIndex; i++) {
            System.out.println(i+1 + " - " + items[i]);
        }
        System.out.println("===============================");
    }

    @Override
    public void delete(int index) {
        int arrayIndex = index - 1;
        if (arrayIndex >= 0 && arrayIndex <= lastIndex) {
            shift(arrayIndex);
        } else {
            System.err.println("Índice Inválido" + index);
        }
    }

    private void shift(final int index) {
        for (int i = index; i < lastIndex; i++) {
            items[i] = items[i + 1];
        }
        lastIndex--; // manter a contagem e impressão corretas
    }
}
