package com.qsp.springbootemployee.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springbootemployee.dto.Employee;
import com.qsp.springbootemployee.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	@Autowired
 private EmployeeRepo repo;
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
		
	}
	public Employee findEmployee(int id) {
		
//		return repo.findById(id).get();
		// To avoid NoSuch ElementException
		Optional<Employee> optional =repo.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
			
		}
		else
		{
			return null;
		}
	}
	public List<Employee> fetchAll() {
		
	   return	repo.findAll();
	}
	public Employee deleteEmp(int id) {
		Optional<Employee> optional =repo.findById(id);
		if(optional.isPresent())
		{
			repo.deleteById(id);
			return optional.get();
			
		}
		else
		{
			return null;
		}
		
	}
	public Employee upDateEmployee( int id, Employee employee) {
		
		     Optional<Employee> optional = repo.findById(id);
		     if(optional.isPresent())
				{
					employee.setId(id);
					return repo.save(employee);
					
				}
				else
				{
					return null;
				}
	}
	public Employee findByEmail(String email) {
		return repo.findEmployeeByEmail(email);
	}
	     public  Employee getEmployeeByPhone(long phone)
	{
//	 return	repo.getEmployeeByPhone(phone);
	    	return repo.empByPhone(phone);
	 
	}
	    public List<Employee> findEmployeeBySalaryGreaterThan(double salary)
	     {
	    	 return repo.findEmployeeBySalaryGreaterThan(salary);
	     }
	
}
