import account.AccountRepository;
import account.AccountService;
import category.CategoryService;
import config.ConnectionManager;
import expense.ExpenseDTO;
import expense.ExpenseRepository;
import expense.ExpenseService;
import income.IncomeDTO;
import income.IncomeService;
import menu.MainMenu;
import org.hibernate.Session;

import java.time.LocalDate;

public class MainApp {
    private static AccountRepository accountRepository = new AccountRepository();
    private static AccountService accountService = new AccountService(accountRepository);
    private static ExpenseService expenseService = new ExpenseService();
    private static ExpenseRepository expenseRepository = new ExpenseRepository();
    private static CategoryService categoryService = new CategoryService();
    private static IncomeService incomeService = new IncomeService();
    private static MainMenu mainMenu = new MainMenu();
    public static void main(String[] args) {
        Session session = ConnectionManager.getSession();
        session.close();

        mainMenu.begin();

    }

}
