package com.example.demo.service;

import com.example.demo.domain.AbstractEntity;

import java.util.List;

public interface IService<T extends AbstractEntity> {
    T create(T t);
    void update(T t);
    void delete(Long id);
    List<T> bulkCreate(List<T> t);
}
