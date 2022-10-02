import account.AccountRepository;
import account.AccountService;
import config.ConnectionManager;
import expense.EpenseDTO;
import org.hibernate.Session;

import java.math.BigDecimal;

public class MainApp {
private static AccountRepository accountRepository = new AccountRepository();
private static AccountService  accountService = new AccountService(accountRepository);
    public static void main(String[] args) {
        System.out.println("sprawdzam czy dziala");
        Session session = ConnectionManager.getSession();
        session.close();

        /*accountService.addAccount("12323434560000786543443415","Maco");
        accountService.addAccount("12323434560000786543443400","Jaco");
        accountService.addAccount("12323434560000786543443409","Waco");*/

        //accountService.showAccounts();

        //accountService.deleteAccount();

        accountService.showAccounts();
        EpenseDTO epenseDTO = new EpenseDTO("12323434560000786543443409",new BigDecimal(202.22),"Transport","paliwo");



    }

}
