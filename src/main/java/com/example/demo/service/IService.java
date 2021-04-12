package com.example.demo.service;

import com.example.demo.domain.AbstractEntity;

public interface IService<T extends AbstractEntity> {
    void create(T t);
    void update(T t);
    void delete(Long id);
}
