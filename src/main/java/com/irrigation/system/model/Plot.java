package com.irrigation.system.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Plot")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Plot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column
	private String no;
	@Column
	private String hasSensor;
	@Column
	private Integer retryCount;
	@Column
	private Date timeSlot;
	@Column
	private String isIrrigated;
	@Column
	private Integer waterQty;
	@Column
	private String cropType;
	@Column
	private Integer cultivatedArea;


}
