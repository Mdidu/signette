package com.signette.service;

import com.signette.domains.Post;

import java.util.List;
import java.util.Optional;

public interface GlobalService<T,I> {
    void add(T type);

    void delete(T type);

    void update(T type);

    List<T> findAll();

    T findById(I id);
}
