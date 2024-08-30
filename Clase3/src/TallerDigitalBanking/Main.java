package TallerDigitalBanking;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.addTransaction(new Transaction(100, "deposit", "2024-05-13"));
        account.addTransaction(new Transaction(50, "withdrawal", "2024-05-14"));
        account.addTransaction(new Transaction(200, "deposit", "2024-05-15"));
        account.addTransaction(new Transaction(150, "deposit", "2024-05-16"));
        account.addTransaction(new Transaction(75, "withdrawal", "2024-05-17"));

        // Prueba las funcionalidades aquí
        // Puedes comentar estas líneas y pedir a los estudiantes que las descomenten una vez que hayan completado los TODOs
        //1
        account.getTotalBalance().ifPresent(balance -> System.out.println("Saldo total: " + balance));
        //5
        account.getTotalDeposits().ifPresent(total -> System.out.println("Total de depósitos: " + total));
        //6
        account.getLargestWithdrawal().ifPresent(transaction -> System.out.println("Retiro de mayor monto: " + transaction.getAmount()));
        //7
        account.getTransactionsOnDate("2024-05-13").ifPresent(transactions -> transactions.forEach(transaction -> System.out.println("El valor de la trx filtrada para la fecha 2024-05-13 es: " + transaction.getAmount())));
        //8
        account.getAverageTransactionAmount().ifPresent(average -> System.out.println("Promedio de montos: " + average));
        //9
        System.out.println("Las transacciones mayores a 100 son: ");
        account.getTransactionsWithAmountGreaterThan(100).ifPresent(transactions -> transactions.forEach(transaction -> System.out.println(transaction.getAmount())));
        //10
        BankAccount targetAccount = new BankAccount();
        BankAccount.transfer(account, targetAccount, 50);
        System.out.println("Se ha añadido una nueva transferencia");
        System.out.println("Cuenta Origen: ");
        System.out.println(account);
        System.out.println("Cuenta Destino: ");
        System.out.println(targetAccount);
        //1
        account.getTotalBalance().ifPresent(balance -> System.out.println("Saldo total de la cuenta origen: " + balance));
        //1
        targetAccount.getTotalBalance().ifPresent(balance -> System.out.println("Saldo total de la cuenta destino: " + balance));
        //11
        account.getTotalWithdrawals().ifPresent(total -> System.out.println("Total de retiros: " + total));
        //12
        account.getTransactionsSummary().forEach((type, sum) -> System.out.println("Tipo: " + type + ", Total: " + sum));
    }
}
