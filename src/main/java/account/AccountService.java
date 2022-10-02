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
            throw new IllegalArgumentException("Bad account numer lenght or name too long");
        }
    }

    public void showAccounts() {
        List<Account> list = accountRepository.getAccounts();
        list.forEach(account -> System.out.println("Account name: " + account.getName()
                + "\nAccount number: " + account.getAccountNumber()));
    }

    public void deleteAccount() {
        Account account = new Account();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Delete account by \n1.ID \n2.Account number \n3.Account name");
        int choice = Integer.parseInt(scanner.nextLine());
        main:
        while (true) {
            switch (choice) {
                case 1 -> {
                    System.out.println("Write account ID: ");
                    long id = Long.parseLong(scanner.nextLine());
                    //    Account account = session.get(Account.class,id);
                    //    account.setId(id);
                    accountRepository.delete(id);
                    break main;
                }
            }
        }
    }
}
