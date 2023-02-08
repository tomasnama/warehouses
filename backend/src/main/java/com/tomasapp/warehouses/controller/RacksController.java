package com.tomasapp.warehouses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.tomasapp.warehouses.entity.Racks;
import com.tomasapp.warehouses.service.RacksService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/racks")
@Slf4j
public class RacksController {
	
	@Autowired
	RacksService racksService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<List<Racks>> getRacks(@PathVariable("id") int warehouseId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(racksService.findRacks(warehouseId)); 
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, e.getMessage());
		}	
	}
	
	@PostMapping
	public ResponseEntity<Racks> createRacks(@RequestBody Racks rack) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(racksService.save(rack)); 
		} catch (Exception e) {
			log.error(e.getMessage());
			if (e.getMessage().contains("ERROR")) {
				throw new ResponseStatusException(
						HttpStatus.CONFLICT, e.getMessage());
			}
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
		try {
			racksService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body(Boolean.TRUE); 
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

}
