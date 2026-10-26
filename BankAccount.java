public class BankAccount {
    private final String owner;
    private final String accountNumber;
    private double balance;
    private static int accountsCount;

    public BankAccount(String owner, String accountNumber) {
        this(owner, accountNumber, 0);
    }

    public BankAccount(String owner, String accountNumber, double initialBalance) {
        if (owner == null || owner.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя владельца не может быть пустым.");
        }
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Номер счёта не может быть пустым.");
        }
        if (!Double.isFinite(initialBalance) || initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс должен быть неотрицательным числом.");
        }

        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        accountsCount++;
    }

    public String getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public static int getAccountsCount() {
        return accountsCount;
    }

    public void deposit(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException("Сумма пополнения должна быть больше нуля.");
        }
        if (!Double.isFinite(balance + amount)) {
            throw new IllegalArgumentException("Сумма пополнения слишком велика.");
        }

        balance += amount;
    }

    public void withdraw(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException("Сумма снятия должна быть больше нуля.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Недостаточно средств на счёте.");
        }

        balance -= amount;
    }
}
