package com.example.tftic.labo.bll.services.service;

import com.example.tftic.labo.models.entity.Salle;

import java.util.List;

public interface CrudService<T,ID> {
    List<T> getAll();
    T getById(ID id);
    T insert(T entity);
    T update(ID id,T entity);
    void delete(ID id);
}
