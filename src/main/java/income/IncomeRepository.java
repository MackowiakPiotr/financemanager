package income;

import account.Account;
import config.ConnectionManager;
import expense.Expense;
import jakarta.persistence.EntityManager;

import java.util.List;

public class IncomeRepository {
    public void add(Income income) {
        EntityManager em = ConnectionManager.getEntityManager();
        em.getTransaction().begin();
        em.persist(income);
        em.getTransaction().commit();
        em.close();
    }

    public List<Income> getIncomes(Account account) {
        EntityManager em = ConnectionManager.getEntityManager();
        return em.createQuery("from Income i where i.account = :account", Income.class)
                .setParameter("account", account)
                .getResultList();
    }
    public void delete(Long id){

        EntityManager em = ConnectionManager.getEntityManager();
        em.getTransaction().begin();
        em.createQuery("delete from Income i where i.id = :id")
                .setParameter("id",id)
                        .executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}