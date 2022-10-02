package category;

import expense.Expense;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
private String name;

@OneToMany(mappedBy = "category")
    List<Expense> expenseList;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
