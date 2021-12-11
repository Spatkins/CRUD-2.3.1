package web.repositories;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository implements Repositories<User> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getList() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void remove(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User getByName(String username) {
        return entityManager.createQuery("from User u where u.username =:username", User.class)
                .setParameter("username", username).getSingleResult();
    }
}
