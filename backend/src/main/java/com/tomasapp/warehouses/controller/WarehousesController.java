package com.tomasapp.warehouses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.tomasapp.warehouses.entity.Warehouses;
import com.tomasapp.warehouses.service.WarehousesService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/warehouses")
@Slf4j
public class WarehousesController {
	
	@Autowired
	WarehousesService warehousesService;

	@GetMapping
	public ResponseEntity<List<Warehouses>> getWarehouses() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(warehousesService.findAll()); 
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, e.getMessage());
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Warehouses> createWarehouses(@RequestBody Warehouses warehouse) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(warehousesService.save(warehouse)); 
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Warehouses> getWarehouse(@PathVariable("id") Integer id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(warehousesService.getWarehouse(id)); 
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Warehouses> updateWarehouses(@RequestBody Warehouses warehouse, @PathVariable("id") Integer id) {
		try {
			warehouse.setId(id);
			return ResponseEntity.status(HttpStatus.OK).body(warehousesService.save(warehouse)); 
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
		try {
			warehousesService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body(Boolean.TRUE); 
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	
	

}
