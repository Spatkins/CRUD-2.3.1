package mvc_hibernate.service;

import mvc_hibernate.model.User;


import java.util.List;

public interface UserService {
    void createUsersTable();

    List<User> getAllUsers();

    void saveUser(User user);

    User getUserById(int id);

    void removeUser(int id);

}
