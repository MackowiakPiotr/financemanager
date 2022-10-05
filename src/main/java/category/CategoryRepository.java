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

    public void add(Category category) {
        EntityManager entityManager = ConnectionManager.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(category);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Category category) {

        EntityManager entityManager = ConnectionManager.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Category c where c.id = : id")
                .setParameter("id", category.getId())
                .executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
