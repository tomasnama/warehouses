package com.tomasapp.warehouses.service;

import java.util.List;

import com.tomasapp.warehouses.entity.Racks;

public interface RacksService {

	List<Racks> findAll();

	List<Racks> findRacks(int warehouseId);

	Racks save(Racks rack) throws Exception;

	void delete(Integer id);

}
