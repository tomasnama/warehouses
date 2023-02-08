package com.tomasapp.warehouses.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Racks {
	
	@Id
	private int id;
	
	@Column
	@Nonnull
	private int warehouseId;
	
	@Column
	@Nonnull
	private String uuid;
	
	@Column
	@Nonnull
	private String type;
	

}
