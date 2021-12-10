package web.repositories;

import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@org.springframework.stereotype.Repository
public class UserRepository implements Repository<User> {

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
        return entityManager.find(User.class, username);
    }
}
