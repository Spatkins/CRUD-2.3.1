package web.repositories;

import java.util.List;

public interface Repository<T> {


    List<T> getList();

    void save(T t);

    T getById(Long id);

    T getByName(String name);

    void remove(Long id);
}
