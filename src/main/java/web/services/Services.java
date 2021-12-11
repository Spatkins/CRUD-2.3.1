package web.services;

import java.util.List;

public interface Services<T> {
    List<T> getList();

    void save(T t);

    T getById(Long id);

//    T getByName(String name);

    void remove(Long id);


}
