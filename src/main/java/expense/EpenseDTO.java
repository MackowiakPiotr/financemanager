package expense;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EpenseDTO {
    String accountNumber;
    BigDecimal amount;
    String category;
    String comment;

    public EpenseDTO(String accountNumber, BigDecimal amount, String category, String comment) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.category = category;
        this.comment = comment;

    }




}
