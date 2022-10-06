package expense;

import account.Account;
import account.AccountRepository;
import category.Category;
import category.CategoryRepository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class ExpenseService {
    private final AccountRepository accountRepository = new AccountRepository();
    private final CategoryRepository categoryRepository = new CategoryRepository();
    private final ExpenseRepository expenseRepository = new ExpenseRepository();

    public void addExpense(ExpenseDTO expenseDTO) {
        Account account = accountRepository.findByAccountNumber(expenseDTO.accountNumber);
        Category category = categoryRepository.findByName(expenseDTO.category);
        Expense expense = new Expense();

        expense.setAccount(account);
        expense.setCategory(category);
        expense.setExpenseAddDate(LocalDate.now());
        expense.setComment(expenseDTO.comment);
        expense.setAmount(expenseDTO.amount);
        expenseRepository.add(expense);
    }

    public void getAllExpensesForAccount(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        List<Expense> expenseList = expenseRepository.getExpenses(account);

        System.out.println("List of expenses for account number: " + account.getAccountNumber());
        expenseList.forEach(System.out::println);
    }

    public void getExpensesForAccountGroupByCategory(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        List<Expense> expenseList = expenseRepository.getExpenses(account);
        expenseList.sort(Comparator.comparingLong(e -> e.getCategory().getId()));
        expenseList.forEach(System.out::println);
    }

    public void deleteExpenseById(Long id) {
        expenseRepository.delete(id);
    }
    public void getExpensesBetweenDate(String accountNumber, LocalDate startDate, LocalDate endDate) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        List<Expense> expenses = expenseRepository.getExpenses(account);
        for (Expense expense : expenses) {
            if (expense.getExpenseAddDate().isAfter(startDate.minusDays(1))
                    && expense.getExpenseAddDate().isBefore(endDate.plusDays(1))) {
                System.out.println(expense);
            }
        }
    }
}
