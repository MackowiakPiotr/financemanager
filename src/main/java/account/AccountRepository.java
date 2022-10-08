package account;

import config.ConnectionManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;
//import org.hibernate.Session;

import java.util.List;

public class AccountRepository {

    public void addToDB(Account account) {
        Session session = ConnectionManager.getSession();
        session.getTransaction().begin();
        session.persist(account);
        session.getTransaction().commit();
        session.close();
    }

    public List<Account> getAccounts() {
        Session session = ConnectionManager.getSession();
        List<Account> fromAccount = session.createQuery("from Account ", Account.class)
                .list();
        session.close();
        return fromAccount;

    }

    public void delete(Account account) {
        EntityManager em = ConnectionManager.getEntityManager();
        em.getTransaction().begin();
        String sql = "delete from Account a where ";
        if (account.getId() != null) {
            sql = sql + "a.id =:param ";
            em.createQuery(sql)
                    .setParameter("param", account.getId())
                    .executeUpdate();
        } else if (account.getAccountNumber() != null) {
            sql = sql + "a.accountNumber =:param ";
            em.createQuery(sql).setParameter("param", account.getAccountNumber())
                    .executeUpdate();

        }
        em.getTransaction().commit();
        em.close();
    }
    public void delete2 (Account account){

        EntityManager em = ConnectionManager.getEntityManager();
        em.getTransaction().begin();
        em.remove(account);
        em.getTransaction().commit();
    }

    public Account findById(Long id) {
        EntityManager em = ConnectionManager.getEntityManager();
        Account foundAccount = em.find(Account.class, id);
        em.close();
        return foundAccount;

    }

    public Account findByAccountNumber(String accountNumber) {

        EntityManager em = ConnectionManager.getEntityManager();
        return (Account) em.createQuery("from Account a where a.accountNumber = :param")
                .setParameter("param", accountNumber)
                .getSingleResult();
    }

}
