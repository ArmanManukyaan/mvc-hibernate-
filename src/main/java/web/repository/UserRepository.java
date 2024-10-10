package web.repository;
import org.springframework.stereotype.Repository;
import web.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }

    @Transactional
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Transactional
    public User findById(int id) {
        return entityManager.find(User.class, id);
    }

    public List<User> findAll() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }
}