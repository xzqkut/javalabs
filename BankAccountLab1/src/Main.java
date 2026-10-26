import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount[] accounts = {
                new BankAccount("Анна Иванова", "1001", 1500),
                new BankAccount("Борис Петров", "1002", 750),
                new BankAccount("Вера Сидорова", "1003")
        };

        Scanner scanner = new Scanner(System.in);
        BankAccount selectedAccount = null;

        while (true) {
            printMenu(selectedAccount);
            if (!scanner.hasNextLine()) {
                break;
            }

            Integer choice = readInteger(scanner.nextLine());
            if (choice == null) {
                System.out.println("Введите номер пункта меню.");
                continue;
            }

            switch (choice) {
                case 1:
                    printAccounts(accounts);
                    break;
                case 2:
                    selectedAccount = selectAccount(scanner, accounts, selectedAccount);
                    break;
                case 3:
                    if (selectedAccount == null) {
                        System.out.println("Сначала выберите счёт.");
                    } else {
                        printAccount(selectedAccount);
                    }
                    break;
                case 4:
                    if (selectedAccount == null) {
                        System.out.println("Сначала выберите счёт.");
                    } else {
                        changeBalance(scanner, selectedAccount, true);
                    }
                    break;
                case 5:
                    if (selectedAccount == null) {
                        System.out.println("Сначала выберите счёт.");
                    } else {
                        changeBalance(scanner, selectedAccount, false);
                    }
                    break;
                case 6:
                    System.out.println("Создано счетов: " + BankAccount.getAccountsCount());
                    break;
                case 0:
                    System.out.println("Работа завершена.");
                    return;
                default:
                    System.out.println("Такого пункта нет.");
            }
        }
    }

    private static void printMenu(BankAccount selectedAccount) {
        System.out.println();
        System.out.println("Выбранный счёт: " + (selectedAccount == null ? "нет" : selectedAccount.getAccountNumber()));
        System.out.println("1. Список счетов");
        System.out.println("2. Выбрать или сменить счёт");
        System.out.println("3. Информация о счёте");
        System.out.println("4. Пополнить счёт");
        System.out.println("5. Снять деньги");
        System.out.println("6. Количество созданных счетов");
        System.out.println("0. Выход");
        System.out.print("Ваш выбор: ");
    }

    private static void printAccounts(BankAccount[] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            System.out.println((i + 1) + ". " + accounts[i].getAccountNumber() + " — " + accounts[i].getOwner());
        }
    }

    private static BankAccount selectAccount(Scanner scanner, BankAccount[] accounts, BankAccount current) {
        printAccounts(accounts);
        System.out.print("Введите номер счёта: ");
        if (!scanner.hasNextLine()) {
            return current;
        }

        String number = scanner.nextLine().trim();
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(number)) {
                System.out.println("Выбран счёт " + account.getAccountNumber() + ".");
                return account;
            }
        }

        System.out.println("Счёт с таким номером не найден.");
        return current;
    }

    private static void printAccount(BankAccount account) {
        System.out.println("Владелец: " + account.getOwner());
        System.out.println("Номер счёта: " + account.getAccountNumber());
        System.out.printf("Баланс: %.2f%n", account.getBalance());
    }

    private static void changeBalance(Scanner scanner, BankAccount account, boolean deposit) {
        System.out.print(deposit ? "Сумма пополнения: " : "Сумма снятия: ");
        if (!scanner.hasNextLine()) {
            return;
        }

        Double amount = readAmount(scanner.nextLine());
        if (amount == null) {
            System.out.println("Введите корректное число.");
            return;
        }

        try {
            if (deposit) {
                account.deposit(amount);
            } else {
                account.withdraw(amount);
            }
            System.out.printf("Операция выполнена. Баланс: %.2f%n", account.getBalance());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static Integer readInteger(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException exception) {
            return null;
        }
    }

    private static Double readAmount(String input) {
        try {
            return Double.parseDouble(input.trim().replace(',', '.'));
        } catch (NumberFormatException exception) {
            return null;
        }
    }
}
