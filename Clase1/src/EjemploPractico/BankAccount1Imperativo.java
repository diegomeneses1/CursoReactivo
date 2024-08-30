package EjemploPractico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BankAccount1Imperativo {
    private List<Transaction> transactions;

    public BankAccount1Imperativo() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public double getTotalBalance() {
        return transactions.stream()
                .mapToDouble(transaction -> {
                    if (transaction.getType().equals("deposit")) {
                        return transaction.getAmount();
                    } else if (transaction.getType().equals("withdrawal")) {
                        return -transaction.getAmount();
                    } else {
                        return 0;
                    }
                })
                .sum();
    }

    public List<Transaction> getDeposits() {
        return transactions.stream()
                .filter(transaction -> transaction.getType().equals("deposit"))
                .collect(Collectors.toList());
    }

    public Optional<Transaction> getTransactionWithHighestAmount() {
        return transactions.stream()
                .max((t1, t2) -> Double.compare(t1.getAmount(), t2.getAmount()));
    }
}
