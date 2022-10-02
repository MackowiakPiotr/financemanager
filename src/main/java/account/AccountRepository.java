package account;

import config.ConnectionManager;
import jakarta.persistence.EntityManager;
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

    public void delete(Long id) {
     //  Session session = ConnectionManager.getSession();
        EntityManager em = ConnectionManager.getEntityManager();
        em.getTransaction().begin();
        // session.delete(account);

        em.createQuery("delete from Account a where a.id = :param")
                .setParameter("param", id)
                .executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}
