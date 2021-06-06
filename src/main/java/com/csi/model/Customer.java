package com.csi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private int custId;
	private String custName;
	private String custAddress;
	private long custContactNumber;
	private String custEmailId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date custDOB; // dd-MM-yyyy



	
}
