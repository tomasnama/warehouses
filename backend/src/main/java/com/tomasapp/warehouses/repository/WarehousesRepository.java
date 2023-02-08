package com.tomasapp.warehouses.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tomasapp.warehouses.entity.Warehouses;

@Repository
public interface WarehousesRepository extends CrudRepository<Warehouses, Integer>{

}
