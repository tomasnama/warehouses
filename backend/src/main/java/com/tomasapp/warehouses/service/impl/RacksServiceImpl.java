package com.tomasapp.warehouses.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomasapp.warehouses.constant.Family;
import com.tomasapp.warehouses.constant.RackType;
import com.tomasapp.warehouses.entity.Racks;
import com.tomasapp.warehouses.entity.Warehouses;
import com.tomasapp.warehouses.repository.RacksRepository;
import com.tomasapp.warehouses.repository.WarehousesRepository;
import com.tomasapp.warehouses.service.RacksService;

@Service
public class RacksServiceImpl implements RacksService {
	
	@Autowired
	RacksRepository racksRepository;
	
	@Autowired
	WarehousesRepository warehousesRepository;

	@Override
	public List<Racks> findAll() {
		return (List<Racks>) racksRepository.findAll();
	}

	@Override
	public List<Racks> findRacks(int warehouseId) {
		return racksRepository.findAllByWarehouseId(warehouseId);
	}

	@Override
	public Racks save(Racks rack) throws Exception {
		Warehouses warehouse = warehousesRepository.findById(rack.getWarehouseId()).orElseThrow();
		if (warehouse.getSize()<= racksRepository.countByWarehouseId(rack.getWarehouseId())) {
			throw new Exception("Número máximo de estanterias");
		}
		Family family = Family.valueOf(warehouse.getFamily());
		RackType type = RackType.valueOf(rack.getType());
		if (Family.EST.equals(family) && RackType.D.equals(type)) {
			throw new Exception("ERROR EST no puede tener tipo D"); 
		} else if (Family.ROB.equals(family) && RackType.B.equals(type)) {
			throw new Exception("ERROR ROB no puede tener tipo B"); 
		}
		rack.setUuid(UUID.randomUUID().toString());
		return racksRepository.save(rack);
	}

	@Override
	public void delete(Integer id) {
		racksRepository.deleteById(id);
		
	}

}
