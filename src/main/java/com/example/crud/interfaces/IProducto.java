package com.example.crud.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.modelo.Producto;

@Repository
public interface IProducto extends CrudRepository<Producto, Integer> {
}
