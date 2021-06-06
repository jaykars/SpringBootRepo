package com.csi.dao;

import java.util.List;

import com.csi.model.Customer;

public interface CustomerDao {

public void  saveAllData( List<Customer> custlist );
public void saveDataById(Customer customer);
public List<Customer> getAllData();
public Customer getDataById(int custid);
void updateData(int custid ,Customer customer);
void deleteData(int cusid);

	

}
