package income;

import account.Account;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity

public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Setter
    private BigDecimal amount;
    @Setter
    private String comment;
    @Setter
    @Column(name = "income_add_date")
    private LocalDate incomeAddDate;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Income{" +
                "id=" + id +
                ", amount=" + amount +
                ", comment='" + comment + '\'' +
                ", incomeAddDate=" + incomeAddDate +
                '}';
    }
}