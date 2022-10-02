package category;

import account.Account;
import config.ConnectionManager;
import jakarta.persistence.EntityManager;

public class CategoryRepository {
    public Category findByName(String category) {

        EntityManager em = ConnectionManager.getEntityManager();
        return (Category) em.createQuery("from Category c where c.name = :param")
                .setParameter("param", category)
                .getSingleResult();
    }
}
