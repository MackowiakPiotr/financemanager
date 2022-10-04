import account.AccountRepository;
import account.AccountService;
import config.ConnectionManager;
import expense.ExpenseDTO;
import expense.ExpenseRepository;
import expense.ExpenseService;
import income.IncomeDTO;
import income.IncomeService;
import org.hibernate.Session;

public class MainApp {
    private static AccountRepository accountRepository = new AccountRepository();
    private static AccountService accountService = new AccountService(accountRepository);
    private static ExpenseService expenseService = new ExpenseService();
    private static ExpenseRepository expenseRepository = new ExpenseRepository();

    private static IncomeService incomeService = new IncomeService();

    public static void main(String[] args) {
        Session session = ConnectionManager.getSession();
        session.close();

        /*accountService.addAccount("12323434560000786543443415", "Maco");
        accountService.addAccount("12323434560000786543443400", "Jaco");
        accountService.addAccount("12323434560000786543443409", "Waco");*/

        //accountService.showAccounts();

        //   accountService.deleteAccount();

        accountService.showAccounts();
        //EpenseDTO epenseDTO = new EpenseDTO("12323434560000786543443409", new BigDecimal(305.22), "Bill", "electricity");
        //IncomeDTO incomeDTO = new IncomeDTO(new BigDecimal(2544.44), "salary", "12323434560000786543443409");

        //expenseService.addExpense(epenseDTO);
        //incomeService.addIncome(incomeDTO);
        //ExpenseDTO expenseDTO1 = new ExpenseDTO();
        //   expenseDTO1.setAccountNumber("12323434560000786543443409");
        //    expenseService.getAllExpensesForAccount(expenseDTO1);
     //   IncomeDTO incomeDTO1 = new IncomeDTO();
       // incomeDTO1.setAccountNumber("12323434560000786543443409");
       // incomeService.getAllIncomesForAccount(incomeDTO1);

       // accountService.getExpensesAndIncomes("12323434560000786543443409");
        System.out.println(accountService.getSaldo("12323434560000786543443409"));
    }

}
