package menu;

import account.Account;
import category.Category;
import category.CategoryService;
import expense.ExpenseDTO;
import expense.ExpenseRepository;
import expense.ExpenseService;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Scanner;

public class ExpenseMenu {

    ExpenseRepository expenseRepository = new ExpenseRepository();
    ExpenseService expenseService = new ExpenseService();
    CategoryService categoryService = new CategoryService();

    public void begin(Account account) {
        Scanner scanner = new Scanner(System.in);
        String selection = null;
        ExpenseDTO expenseDTO = new ExpenseDTO();
        Category category = new Category();
        expenseDTO.setAccountNumber(account.getAccountNumber());
        do {
            System.out.println("<<<<<<<<<< Expense Details >>>>>>>>>>\n");
            System.out.println(account.getName() + " [" + account.getAccountNumber() + "]");
            System.out.println("[1] Add expense");
            System.out.println("[2] Delete expense");
            System.out.println("[3] View all expenses");
            System.out.println("[4] View expenses group by category");
            System.out.println("[5] Add expense category");
            System.out.println("[6] Delete expense category");
            System.out.println("[7] Back to account menu\n");
            System.out.println("Insert selection\n");

            selection = scanner.nextLine();

            switch (selection) {
                case "1" -> {
                    System.out.println("Insert amount of expense");
                    BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));
                    System.out.println("insert comment for expense");
                    String comment = scanner.nextLine();
                    System.out.println("insert name of category for expense");
                    String categoryName = scanner.nextLine();
                    expenseDTO.setAmount(amount);
                    expenseDTO.setComment(comment);
                    expenseDTO.setCategory(categoryName);
                    expenseDTO.setAccountNumber(account.getAccountNumber());
                    expenseService.addExpense(expenseDTO);
                }
                case "2" -> {
                    System.out.println("Insert id of expense for delete");
                    Long id = Long.parseLong(scanner.nextLine());
                    expenseService.deleteExpenseById(id);
                }
                case "3" -> expenseService.getAllExpensesForAccount(account.getAccountNumber());
                case "4" -> expenseService.getExpensesForAccountGroupByCategory(account.getAccountNumber());
                case "5" -> {
                    System.out.println("Insert new name for category");
                    String categoryName = scanner.nextLine();
                    categoryService.addCategory(categoryName);
                }
                case "6" -> {
                    System.out.println("Insert name to delete category");
                    String categoryName = scanner.nextLine();
                    categoryService.deleteCategory(categoryName);
                }
                case "7" -> System.out.println("back to account menu");
                default -> System.out.println("Invalid selection");
            }

        } while (!Objects.equals(selection, "7"));
    }
}

