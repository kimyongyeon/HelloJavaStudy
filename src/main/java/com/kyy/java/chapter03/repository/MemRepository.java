package com.kyy.java.chapter03.repository;

import com.kyy.java.chapter03.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MemRepository implements  PersistenceRepository {
    List<Product> list = new ArrayList<>();
    @Override
    public void save(Object object) {
        list.add((Product) object);
    }

    @Override
    public void delete(long id) {
        list.remove(id);
    }

    @Override
    public void update(long id, Object object) {
        list.remove(id);
        list.add((Product) object);
    }

    @Override
    public String select(long id) {
        return list.toString();
    }
}
