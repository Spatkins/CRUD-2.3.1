package web.repositories;

import web.model.Role;

import java.util.List;

public class RoleRepository implements Repositories<Role> {
    @Override
    public List<Role> getList() {
        return null;
    }

    @Override
    public void save(Role role) {

    }

    @Override
    public Role getById(Long id) {
        return null;
    }

//    @Override
//    public Role getById(Long id) {
//        return null;
//    }

    @Override
    public Role getByName(String name) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
