package expense;

import account.Account;
import account.AccountRepository;
import category.Category;
import category.CategoryRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpenseService {
    private final AccountRepository accountRepository = new AccountRepository();
    private final CategoryRepository categoryRepository = new CategoryRepository();

    public Expense addExpense(EpenseDTO epenseDTO) {
        Account account = accountRepository.findByAccountNumber(epenseDTO.accountNumber);
        Category category = categoryRepository.findByName(epenseDTO.category);
        Expense expense = new Expense();

        expense.setAccount(account);
        expense.setCategory(category);
        expense.setExpenseAddDate(LocalDate.now());
        expense.setComment(epenseDTO.comment);
        expense.setAmount(epenseDTO.amount);
        return expense;


    }
}
