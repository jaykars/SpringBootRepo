package com.csi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csi.model.Customer;
import com.csi.service.CustomerService;
import com.mysql.cj.log.Log;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/api")
@Slf4j
public class CustomerController {

	@Autowired

	CustomerService cusomerserviceimpl;

	@PostMapping("/savealldata")
	public ResponseEntity <String> saveAllData(@RequestBody List<Customer> custlist) {
		// TODO Auto-generated method stub
		cusomerserviceimpl.saveAllData(custlist);
		log.info("from save all data");
		
		return ResponseEntity.ok( "Data saved successfully");
	}

	@PostMapping("/savedatabyid")
	public  ResponseEntity <String> saveDataById(@RequestBody Customer customer) {
		// TODO Auto-generated method stub
		cusomerserviceimpl.saveDataById(customer);
		return  ResponseEntity.ok("Data saved successfully");
	}

	@GetMapping("/getalldata")
	public ResponseEntity <List<Customer> >getAllData() {
		// TODO Auto-generated method stub
		return  ResponseEntity.ok(cusomerserviceimpl.getAllData());
	}

	@GetMapping("/getdatabyid/{custid}")
	public  ResponseEntity <Customer >getDataById(@PathVariable int custid) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok( cusomerserviceimpl.getDataById(custid));
	}

	@PutMapping("/updatedata/{custid}")
	public ResponseEntity <String > updateData(@PathVariable int custid, @RequestBody Customer customer) {
		// TODO Auto-generated method stub
		cusomerserviceimpl.updateData(custid, customer);
		
		return  ResponseEntity.ok("Data updated successfully");
	}

	@DeleteMapping("/deletedata/{custid}")

	public ResponseEntity <String >deleteData(@PathVariable int custid) {
		// TODO Auto-generated method stub

		cusomerserviceimpl.deleteData(custid);
		
		return  ResponseEntity.ok("Data updated successfully");
	}

}
