package account;

import expense.Expense;
import expense.ExpenseRepository;
import expense.ExpenseService;
import income.Income;
import income.IncomeRepository;
import income.IncomeService;

import java.util.List;
import java.util.Scanner;

public class AccountService {
    public static final int MAX_NAME_LENGTH = 100;
    private final AccountRepository accountRepository;
    private final ExpenseRepository expenseRepository = new ExpenseRepository();
    private final IncomeRepository incomeRepository = new IncomeRepository();

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void addAccount(String accountNumber, String name) {

        if (accountNumber.length() == 26 && name.length() <= MAX_NAME_LENGTH) {

            Account account = new Account();
            account.setName(name);
            account.setAccountNumber(accountNumber);
            accountRepository.addToDB(account);
        } else {
            throw new IllegalArgumentException("Bad account number length or name too long");
        }
    }

    public void showAccounts() {
        List<Account> list = accountRepository.getAccounts();
        list.forEach(account -> System.out.println("Account id: " + account.getId() + "  Account name: " + account.getName()
                + "\nAccount number: " + account.getAccountNumber()
                + "\n-------------------------------------------"));
    }

    public void deleteAccount() {
        Account account = new Account();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Delete account by \n1.ID \n2.Account number");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1 -> {
                System.out.println("Write account ID: ");
                long id = Long.parseLong(scanner.nextLine());
                account.setId(id);
                accountRepository.delete(account);

            }
            case 2 -> {
                System.out.println("Write account number: ");
                String accountNumber = scanner.nextLine();
                account.setAccountNumber(accountNumber);
                accountRepository.delete(account);

            }
            default -> System.out.println("Next time select correct number");
        }
    }
    public void getExpensesAndIncomes(String accountNumber){
        Account account = accountRepository.findByAccountNumber(accountNumber);
        List<Expense> expenses = expenseRepository.getExpenses(account);
        List<Income> incomes = incomeRepository.getIncomes(account);
        System.out.println("List of expenses and incomes for account number: "+accountNumber  );
        expenses.forEach(System.out::println);
        incomes.forEach(System.out::println);

    }
}
