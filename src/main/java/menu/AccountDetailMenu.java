package menu;

import account.Account;
import account.AccountRepository;
import account.AccountService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class AccountDetailMenu {
    AccountRepository accountRepository = new AccountRepository();
    AccountService accountService = new AccountService(accountRepository);
    IncomeMenu incomeMenu = new IncomeMenu();
    ExpenseMenu expenseMenu = new ExpenseMenu();
    MainMenu mainMenu = new MainMenu();

    public void begin(Account account) {
        Scanner scanner = new Scanner(System.in);
        String selection =null;
        do {
            System.out.println("<<<<<<<<<< Account Details >>>>>>>>>>\n");
            System.out.println(account.getName() + " [" + account.getAccountNumber() + "]");
            System.out.println("[1] Income");
            System.out.println("[2] Expense");
            System.out.println("[3] View expenses and incomes");
            System.out.println("[4] View saldo");
            System.out.println("[5] View saldo between inserted dates");
            System.out.println("[6] Back to Main menu\n");
            System.out.println("Insert selection\n");

            selection = scanner.nextLine();

            switch (selection) {
                case "1" -> incomeMenu.begin(account);
                case "2" -> expenseMenu.begin(account);
                case "3" -> accountService.getExpensesAndIncomes(account.getAccountNumber());
                case "4" ->
                        System.out.println("Saldo for account: " + accountService.getSaldo(account.getAccountNumber()));
                case "5" -> {
                    System.out.println("Insert start date (YYYY-MM-DD)");
                    String startDate = scanner.nextLine();
                    System.out.println("Insert end date (YYYY-MM-DD)");
                    String endDate = scanner.nextLine();
                    BigDecimal saldoBetweenDate = accountService.getSaldoBetweenDate(account.getAccountNumber(),
                            LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                            LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                    System.out.println("Saldo between: " + startDate + " to " + endDate + "\n" + saldoBetweenDate);

                }
                case "6" -> System.out.println("back to main menu");
                default -> System.out.println("Invalid selection");
            }

        } while (!Objects.equals(selection, "6"));
    }

}
