package com.tomasapp.warehouses.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tomasapp.warehouses.entity.Racks;

@Repository
public interface RacksRepository extends CrudRepository<Racks, Integer>{

	List<Racks> findAllByWarehouseId(Integer warehouseId);
	
	long countByWarehouseId(Integer warehouseId);

}
