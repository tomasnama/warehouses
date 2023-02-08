package com.tomasapp.warehouses.service;

import java.util.List;

import com.tomasapp.warehouses.entity.Warehouses;

public interface WarehousesService {

	List<Warehouses> findAll();

	Warehouses save(Warehouses warehouse);

	Warehouses getWarehouse(Integer id);

	void delete(Integer id);

}
