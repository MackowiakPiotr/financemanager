package expense;

import account.Account;
import config.ConnectionManager;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ExpenseRepository {

    public void add(Expense expense) {
        EntityManager em = ConnectionManager.getEntityManager();
        em.getTransaction().begin();
        em.persist(expense);
        em.getTransaction().commit();
        em.close();
    }

    public List<Expense> getExpenses(Account account) {
        EntityManager em = ConnectionManager.getEntityManager();
        return em.createQuery("from Expense e where e.account = :account", Expense.class)
                .setParameter("account", account)
                .getResultList();
    }

    public void delete(Long id) {

        EntityManager em = ConnectionManager.getEntityManager();
        em.getTransaction().begin();
        em.createQuery("delete from Expense e where e.id = : id")
                .setParameter("id", id)
                .executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}
