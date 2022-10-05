package income;

import account.Account;
import account.AccountRepository;
import expense.Expense;
import expense.ExpenseDTO;

import java.time.LocalDate;
import java.util.List;

public class IncomeService {
    private final AccountRepository accountRepository = new AccountRepository();
    private final IncomeRepository incomeRepository = new IncomeRepository();

    public void addIncome(IncomeDTO incomeDTO) {
        Account account = accountRepository.findByAccountNumber(incomeDTO.getAccountNumber());
        Income income = new Income();
        income.setIncomeAddDate(LocalDate.now());
        income.setAmount(incomeDTO.getAmount());
        income.setComment(incomeDTO.getComment());
        income.setAccount(account);
        incomeRepository.add(income);
    }
    public void getAllIncomesForAccount(IncomeDTO incomeDTO) {
        Account account = accountRepository.findByAccountNumber(incomeDTO.getAccountNumber());
        List<Income> incomesList = incomeRepository.getIncomes(account);

        System.out.println("List of incomes for account number: " + account.getAccountNumber());
        incomesList.forEach(System.out::println);
    }
    public void deleteIncomeById (Long id){
        incomeRepository.delete(id);
    }

}
