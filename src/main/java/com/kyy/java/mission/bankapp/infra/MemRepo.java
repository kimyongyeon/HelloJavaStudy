package com.kyy.java.mission.bankapp.infra;

import java.util.List;

public interface MemRepo<T> {
    void create(T t);

    void update(long id, T t);

    void delete(long id);

    T findById(long id);

    List<T> findAll();

}
