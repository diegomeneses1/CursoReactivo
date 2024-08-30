package EjemploPractico;

import java.util.ArrayList;
import java.util.List;

//En el ejemplo funcional, utilizamos lambdas para expresar operaciones sobre los elementos de la lista
//de manera más concisa. También utilizamos Optional para manejar posibles valores nulos, y Stream junto
// con métodos como filter, map, y collect para realizar operaciones de filtrado y transformación sobre
// la lista de transacciones.

public class BankAccount2Funcional {
    private List<Transaction> transactions;

    public BankAccount2Funcional() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public double getTotalBalance() {
        double totalBalance = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getType().equals("deposit")) {
                totalBalance += transaction.getAmount();
            } else if (transaction.getType().equals("withdrawal")) {
                totalBalance -= transaction.getAmount();
            }
        }
        return totalBalance;
    }

    public List<Transaction> getDeposits() {
        List<Transaction> deposits = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getType().equals("deposit")) {
                deposits.add(transaction);
            }
        }
        return deposits;
    }
}
