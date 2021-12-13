package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import web.model.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import web.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service("userService")
public class  UserService implements Services<User> {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userDAO) {
        this.userRepository = userDAO;
    }

    @Override
    @Transactional
    public List<User> getList() {
        return userRepository.getList();
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public User getByName(String name) {
        return userRepository.getByName(name) ;
    }

    @Override
    @Transactional
    public User getById(Long id ) {
        Optional<User> optional = Optional.ofNullable(userRepository.getById(id));
        User user;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException("User not found for id :: " + id);
        }
        return user;
    }

    @Override
    @Transactional
    public void remove(Long id) {
        userRepository.remove(id);
    }
























//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = getByName(username);
//        if (user == null) {
//            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
//        }
//        return user;
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//                user.getAuthorities());
//    }

//    private Collection<? extends GrantedAuthority> setRolesToAuthorities(Collection<Role> roles) {
//        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//    }
}
