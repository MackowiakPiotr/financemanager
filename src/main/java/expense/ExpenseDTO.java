package expense;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Setter
@Getter
public class ExpenseDTO {
    String accountNumber;
    BigDecimal amount;
    String category;
    String comment;

    public ExpenseDTO(String accountNumber, BigDecimal amount, String category, String comment) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.category = category;
        this.comment = comment;

    }
}
