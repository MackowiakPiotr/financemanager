package account;

import expense.Expense;
import income.Income;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Account {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Setter
    @Column(name = "account_number")
    private String accountNumber;
    @Setter
    private String name;
    @Setter
    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    private List<Income> incomeList;

    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    private List<Expense> expenseList;


    public Account(String accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.name = name;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }
}
