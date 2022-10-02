package expense;

import account.Account;
import account.AccountRepository;
import category.Category;
import category.CategoryRepository;

import java.time.LocalDate;
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

    public void getAllExpensesForAccount(ExpenseDTO expenseDTO) {
        Account account = accountRepository.findByAccountNumber(expenseDTO.getAccountNumber());
        List<Expense> expenseList = expenseRepository.getExpenses(account);

        System.out.println("List of expenses for account number: " + account.getAccountNumber());
        expenseList.forEach(System.out::println);
    }
    public void deleteExpense(Long id){
        expenseRepository.delete(id);
    }
}
