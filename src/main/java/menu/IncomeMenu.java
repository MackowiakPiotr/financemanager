package menu;

import account.Account;
import income.IncomeDTO;
import income.IncomeRepository;
import income.IncomeService;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Scanner;

public class IncomeMenu {
    private IncomeRepository incomeRepository = new IncomeRepository();
    private IncomeService incomeService = new IncomeService();

    public void begin(Account account) {

        Scanner scanner = new Scanner(System.in);
        String selection = null;
        IncomeDTO incomeDTO = new IncomeDTO();
        incomeDTO.setAccountNumber(account.getAccountNumber());
        do {
            System.out.println("<<<<<<<<<< Income Details >>>>>>>>>>\n");
            System.out.println(account.getName() + " [" + account.getAccountNumber() + "]\n");
            System.out.println("[1] Add income");
            System.out.println("[2] Delete income");
            System.out.println("[3] View all incomes");
            System.out.println("[4] Back to Main menu\n");
            System.out.println("Insert selection\n");

            selection = scanner.nextLine();

            switch (selection) {
                case "1" -> {
                    try {
                        System.out.println("Insert amount of income");
                        BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));
                        System.out.println("insert comment for income");
                        String comment = scanner.nextLine();
                        incomeDTO.setAmount(amount);
                        incomeDTO.setComment(comment);
                        incomeService.addIncome(incomeDTO);
                    } catch (NumberFormatException exception) {
                        System.err.println("Wrong number format, try again");
                    }
                }
                case "2" -> {
                    System.out.println("Insert id of income to delete");
                    Long id = Long.parseLong(scanner.nextLine());
                    incomeService.deleteIncomeById(id);
                }
                case "3" -> incomeService.getAllIncomesForAccount(incomeDTO);
                case "4" -> System.out.println("back to account menu");
                default -> System.out.println("Invalid selection");
            }

        } while (!Objects.equals(selection, "4"));
    }
}

