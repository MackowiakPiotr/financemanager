package expense;

import config.ConnectionManager;
import income.Income;
import jakarta.persistence.EntityManager;

public class ExpenseRepository {

public void add(Expense expense){
    EntityManager em = ConnectionManager.getEntityManager();
    em.getTransaction().begin();
    em.persist(expense);
    em.getTransaction().commit();
    em.close();
}
}
