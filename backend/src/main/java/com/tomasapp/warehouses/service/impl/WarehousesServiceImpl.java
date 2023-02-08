package com.tomasapp.warehouses.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomasapp.warehouses.entity.Warehouses;
import com.tomasapp.warehouses.repository.WarehousesRepository;
import com.tomasapp.warehouses.service.WarehousesService;

@Service
public class WarehousesServiceImpl implements WarehousesService {
	
	@Autowired
	WarehousesRepository warehousesRepository;

	@Override
	public List<Warehouses> findAll() {
		return (List<Warehouses>) warehousesRepository.findAll();
	}

	@Override
	public Warehouses save(Warehouses warehouse) {
		warehouse.setUuid(UUID.randomUUID().toString());
		return warehousesRepository.save(warehouse);
	}

	@Override
	public Warehouses getWarehouse(Integer id) {
		return warehousesRepository.findById(id).orElseThrow();
	}

	@Override
	public void delete(Integer id) {
		warehousesRepository.deleteById(id);
		
	}

}
