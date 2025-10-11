package src.com.gdb;

import java.util.List;

public class Transaction {
    List<Item> items;

    public Transaction(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "items=" + items +
                '}';
    }
}
