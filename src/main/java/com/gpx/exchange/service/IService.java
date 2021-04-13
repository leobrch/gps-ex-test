package com.gpx.exchange.service;

import com.gpx.exchange.domain.AbstractEntity;

import java.util.List;

public interface IService<T extends AbstractEntity> {
    T create(T t);
    List<T> bulkCreate(List<T> t);
}
