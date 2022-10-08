package income;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class IncomeDTO {
    private BigDecimal amount;
    private String comment;
    private String accountNumber;


    public IncomeDTO(BigDecimal amount, String comment, String accountNumber) {
        this.amount = amount;
        this.comment = comment;
        this.accountNumber = accountNumber;
    }
}
