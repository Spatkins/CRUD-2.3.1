package mvc_hibernate.dao;

import mvc_hibernate.model.User;

import java.util.List;

public interface UserDAO {
//    void createUsersTable();
    List<User> getAllUsers();
    void saveUser(User user);
    User getUserById(int id);
    void removeUser(int id);
}
