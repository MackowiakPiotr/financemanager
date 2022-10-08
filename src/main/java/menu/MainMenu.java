package menu;

import account.Account;
import account.AccountRepository;
import account.AccountService;
import jakarta.persistence.NoResultException;

import java.util.Objects;
import java.util.Scanner;

public class MainMenu {
    private static final AccountRepository accountRepository = new AccountRepository();
    private static final AccountService accountService = new AccountService(accountRepository);
    private static final AccountDetailMenu accountDetailMenu = new AccountDetailMenu();

    public void begin() {
        Scanner scanner = new Scanner(System.in);
        String selection;
        do {


            System.out.println("<<<<<<<<<< FINANCE MANAGER >>>>>>>>>>\n");
            System.out.println("[1] Create new account");
            System.out.println("[2] Show existing accounts");
            System.out.println("[3] Account details");
            System.out.println("[4] Delete account");
            System.out.println("[5] Exit application\n");
            System.out.println("Insert selection\n");

            selection = scanner.nextLine();

            switch (selection) {
                case "1" -> {
                    System.out.println("Insert account number: \n");
                    String accountNumber = scanner.nextLine();
                    System.out.println("Insert account name: \n");
                    String name = scanner.nextLine();
                    String regex = "[^a-z]+";
                    if (accountNumber.matches(regex)) {

                        try {
                            accountService.addAccount(accountNumber, name);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else System.err.println("Bad account number format");
                }
                case "2" -> accountService.showAccounts();
                case "3" -> {
                    System.out.println("Select account by account number or id");
                    System.out.println("[1] Account number\n[2] Account id\n");
                    String choice = scanner.nextLine();
                    if (choice.equals("1")) {
                        System.out.println("Insert account number: \n");
                        String accountNumber = scanner.nextLine();
                        Account account;
                        try {
                            account = accountRepository.findByAccountNumber(accountNumber);
                            accountDetailMenu.begin(account);
                        } catch (NoResultException e) {
                            System.err.println("Bad account number");
                        }

                    } else if (choice.equals("2")) {
                        System.out.println("Insert account id: \n");
                        try {
                            Long id = Long.parseLong(scanner.nextLine());
                            Account account = accountRepository.findById(id);
                            accountDetailMenu.begin(account);
                        } catch (NullPointerException e) {
                            System.err.println("Inserted Id is not in the database");
                        } catch (NumberFormatException e) {
                            System.err.println("Bad id number format");
                        }


                    } else System.out.println("You didn`t make a correct choice");
                }
                case "4" -> accountService.deleteAccount();
                case "5" -> System.out.println("Good Bye");
                default -> System.out.println("Invalid selection");
            }

        } while (!Objects.equals(selection, "5"));
    }
}
