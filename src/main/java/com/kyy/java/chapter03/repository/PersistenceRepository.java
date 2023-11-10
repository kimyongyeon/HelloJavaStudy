package com.kyy.java.chapter03.repository;

public interface PersistenceRepository {
    void save(Object object);
    void delete(long id);
    void update(long id, Object object);
    String select(long id);
}
