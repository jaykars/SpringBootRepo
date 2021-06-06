package com.csi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csi.dao.CustomerDao;
import com.csi.model.Customer;

@Service
public class CustomerServiceImpl  implements CustomerService{

	@Autowired
	CustomerDao customerDaoImpl;
	@Override
	public void saveAllData(List<Customer> custlist) {
		// TODO Auto-generated method stub
		customerDaoImpl.saveAllData(custlist);
	}

	@Override
	public void saveDataById(Customer customer) {
		// TODO Auto-generated method stub
		customerDaoImpl.saveDataById(customer);
	}

	@Override
	public List<Customer> getAllData() {
		// TODO Auto-generated method stub
		return customerDaoImpl.getAllData();
	}

	@Override
	public Customer getDataById(int custid) {
		// TODO Auto-generated method stub
		return customerDaoImpl.getDataById(custid);
	}

	@Override
	public void updateData(int custid, Customer customer) {
		// TODO Auto-generated method stub
		customerDaoImpl.updateData(custid, customer);
	}

	@Override
	public void deleteData(int cusid) {
		// TODO Auto-generated method stub
		
		customerDaoImpl.deleteData(cusid);
	}

}
