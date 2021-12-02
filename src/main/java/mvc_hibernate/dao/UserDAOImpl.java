package mvc_hibernate.dao;

import mvc_hibernate.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void createUsersTable() {

        entityManager.createNativeQuery("CREATE TABLE if not exists users  " +
                        "(id int auto_increment, " +
                        " name VARCHAR(16) null , " +
                        " lastname VARCHAR (16) null , " +
                        " age int null , " +
                        " PRIMARY KEY (id))")
                .executeUpdate();
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void removeUser(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
