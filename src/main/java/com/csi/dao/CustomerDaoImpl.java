package com.csi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import com.csi.model.Customer;
@Component
public class CustomerDaoImpl implements CustomerDao {

	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

	@Override
	public void saveAllData(List<Customer> custlist) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		
		
		
		for (Customer c : custlist) {
			Transaction transaction = session.beginTransaction();

			session.save(c);
			transaction.commit();
		}

		
		
	}

	@Override
	public void saveDataById(Customer customer) {
		// TODO Auto-generated method stub

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(customer);
		transaction.commit();

	}

	@Override
	public List<Customer> getAllData() {
		// TODO Auto-generated method stub

		Session session = factory.openSession();
		List<Customer> custlist = session.createQuery("from Customer").list();

		return custlist;
	}

	@Override
	public Customer getDataById(int custid) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		List<Customer> custlist = session.createQuery("from Customer").list();
		//Transaction transaction = session.beginTransaction();
		Customer customer = new Customer();
		for (Customer c : custlist) {

			if (c.getCustId() == custid) {
				customer.setCustId(custid);
				customer.setCustName(c.getCustName());
				customer.setCustAddress(c.getCustAddress());
				customer.setCustDOB(c.getCustDOB());
				customer.setCustEmailId(c.getCustEmailId());
				customer.setCustContactNumber(c.getCustContactNumber());
				
				
			}
		}

		return customer;
	}

	@Override
	public void updateData(int custid, Customer customer) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		List<Customer> custlist = session.createQuery("from Customer").list();
		Transaction beginTransaction = session.beginTransaction();
		for (Customer c : custlist) {

			if (c.getCustId() == custid) {
				c.setCustName(customer.getCustName());
				c.setCustAddress(customer.getCustAddress());
				c.setCustDOB(customer.getCustDOB());
				c.setCustEmailId(customer.getCustEmailId());
				c.setCustContactNumber(customer.getCustContactNumber());
				session.save(c);
				beginTransaction.commit();
			}
		}

	}

	@Override
	public void deleteData(int cusid) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		List<Customer> custlist = session.createQuery("from Customer").list();
		Transaction beginTransaction = session.beginTransaction();
		for (Customer c : custlist) {

			if (c.getCustId() == cusid) {
				session.delete(c);
				beginTransaction.commit();
			}
		}

	}

}
