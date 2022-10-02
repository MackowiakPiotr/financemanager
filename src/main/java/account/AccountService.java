package account;

import java.util.List;
import java.util.Scanner;

public class AccountService {
    public static final int MAX_NAME_LENGTH = 100;
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void addAccount(String accountNumber, String name) {

        if (accountNumber.length() == 26 && name.length() <= MAX_NAME_LENGTH) {

            Account account = new Account();
            account.setName(name);
            account.setAccountNumber(accountNumber);
            accountRepository.addToDB(account);
        } else {
            throw new IllegalArgumentException("Bad account number length or name too long");
        }
    }

    public void showAccounts() {
        List<Account> list = accountRepository.getAccounts();
        list.forEach(account -> System.out.println("Account id: " + account.getId() + "  Account name: " + account.getName()
                + "\nAccount number: " + account.getAccountNumber()
                + "\n-----------------------------------------"));
    }

    public void deleteAccount() {
        Account account = new Account();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Delete account by \n1.ID \n2.Account number");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1 -> {
                System.out.println("Write account ID: ");
                long id = Long.parseLong(scanner.nextLine());
                account.setId(id);
                accountRepository.delete(account);

            }
            case 2 -> {
                System.out.println("Write account number: ");
                String accountNumber = scanner.nextLine();
                account.setAccountNumber(accountNumber);
                accountRepository.delete(account);

            }
            default -> System.out.println("Next time select correct number");
        }
    }
}
