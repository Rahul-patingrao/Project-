package com.qsp.springbootemployee.service;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springbootemployee.dao.EmployeeDao;
import com.qsp.springbootemployee.dto.Employee;
import com.qsp.springbootemployee.exeption.EmailNotFound;
import com.qsp.springbootemployee.exeption.EmployeeListNotFound;
import com.qsp.springbootemployee.exeption.IdNotFound;
import com.qsp.springbootemployee.exeption.PhoneNotFound;
import com.qsp.springbootemployee.exeption.SalaryNotFound;
import com.qsp.springbootemployee.util.ResourseStructure;


@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao dao;
	
	public ResponseEntity<ResourseStructure<Employee>> saveEmployee(Employee employee) {
		
		double salary = employee.getSalary();
		if (salary > 10000) {
			employee.setGrade('A');
		}
		else if(salary >=10000&& salary <20000 )
		{
			employee.setGrade('B');
		}
		else if(salary >=20000&& salary <40000 )
		{
			employee.setGrade('C');
		}
		else
		{
			employee.setGrade('D');
		}
		 ResourseStructure<Employee> structure =new ResourseStructure<Employee>();
		 structure.setMessage("Saved Successful");
		 structure.setStatus(HttpStatus.CREATED.value());
		 structure.setData(dao.saveEmployee(employee));
		return  new ResponseEntity<ResourseStructure<Employee>>(structure,HttpStatus.OK);
	}
	public Employee upDateEmployee( int id, Employee employee) 
	{
		  double salary = employee.getSalary();
		  if (salary > 10000) {
				employee.setGrade('A');
			}
			else if(salary >=10000&& salary <20000 )
			{
				employee.setGrade('B');
			}
			else if(salary >=20000&& salary <40000 )
			{
				employee.setGrade('C');
			}
			else
			{
				employee.setGrade('D');
			}
			return dao.upDateEmployee(id, employee);
			
		 
	    
	
}
	public ResponseEntity<ResourseStructure<Employee>> findEmployee(int id) {
		  Employee employee = dao.findEmployee(id);
		ResourseStructure<Employee> structure =new ResourseStructure<Employee>();
		
		if(employee!=null)
		{
			 structure.setMessage("find Seccssfuly");
			 structure.setStatus(HttpStatus.FOUND.value());
			 structure.setData(dao.findEmployee(id));
			 return  new ResponseEntity<ResourseStructure<Employee>>(structure,HttpStatus.FOUND);
		}
		else 
		{
			 throw new IdNotFound("id not found");
		}
		
	}
	public ResponseEntity<ResourseStructure<Employee>> deleteEmp(int id) 
	{ 
		Employee employee = dao.findEmployee(id);
ResourseStructure<Employee> structure =new ResourseStructure<Employee>();
		
		if(employee!=null)
		{
			 structure.setMessage("Delete Seccssfully");
			 structure.setStatus(HttpStatus.FOUND.value());
			 structure.setData(dao.deleteEmp(id));
			 return new ResponseEntity<ResourseStructure<Employee>>(structure,HttpStatus.FOUND);
		}
		else 
		{
			 throw new IdNotFound("id not found");
		}
		
	}
	public ResponseEntity<ResourseStructure<Employee>> updateEmail( int id , String email) {
		// TODO Auto-generated method stub
		Employee employee = dao.findEmployee(id);
ResourseStructure<Employee> structure =new ResourseStructure<Employee>();
		
		if(employee!=null)
		{    employee.setEmail(email);
			 structure.setMessage(" update Seccssfully");
			 structure.setStatus(HttpStatus.FOUND.value());
			 structure.setData(dao.upDateEmployee(id, employee));
			 return new ResponseEntity<ResourseStructure<Employee>>(structure,HttpStatus.FOUND);
		}
		else 
		{
			 throw new IdNotFound("id not found");
		}
	}
	public ResponseEntity<ResourseStructure<Employee>> updatePhone(int id, long phone) {
		// TODO Auto-generated method stub
		Employee employee = dao.findEmployee(id);
ResourseStructure<Employee> structure =new ResourseStructure<Employee>();
		
		if(employee!=null)
		{    employee.setPhone(phone);;
			 structure.setMessage(" update Seccssfully");
			 structure.setStatus(HttpStatus.FOUND.value());
			 structure.setData(dao.upDateEmployee(id, employee));
			 return new ResponseEntity<ResourseStructure<Employee>>(structure,HttpStatus.FOUND);
		}
		else 
		{
			 throw new IdNotFound("id not found");
		}
	}
	public ResponseEntity<ResourseStructure<Employee>> updateSalary(int id, double salary) {
		// TODO Auto-generated method stub
		Employee employee = dao.findEmployee(id);
ResourseStructure<Employee> structure =new ResourseStructure<Employee>();
		
		if(employee!=null)
		{    employee.setSalary(salary);;
			 structure.setMessage(" update Seccssfully");
			 structure.setStatus(HttpStatus.FOUND.value());
			 structure.setData(dao.upDateEmployee(id, employee));
			 return new ResponseEntity<ResourseStructure<Employee>>(structure,HttpStatus.FOUND);
		}
		else 
		{
			 throw new IdNotFound("id not found");
		}
	}
	public ResponseEntity<ResourseStructure<Employee>> findByEmail(String email) 
	{
		 Employee employee = dao.findByEmail(email);
			ResourseStructure<Employee> structure =new ResourseStructure<Employee>();
			
			if(employee!=null)
			{
				 structure.setMessage("find Seccssfuly");
				 structure.setStatus(HttpStatus.FOUND.value());
				 structure.setData(dao.findByEmail(email));
				 return  new ResponseEntity<ResourseStructure<Employee>>(structure,HttpStatus.FOUND);
			}
			else 
			{
				 throw new EmailNotFound("email not found");
			}
	}
    public  ResponseEntity<ResourseStructure<Employee>> getEmployeeByPhone(long phone)
	{
    	 Employee employee = dao.getEmployeeByPhone(phone);
 		ResourseStructure<Employee> structure =new ResourseStructure<Employee>();
 		
 		if(employee!=null)
 		{
 			 structure.setMessage("find Seccssfuly");
 			 structure.setStatus(HttpStatus.FOUND.value());
 			 structure.setData(dao.getEmployeeByPhone(phone));
 			 return  new ResponseEntity<ResourseStructure<Employee>>(structure,HttpStatus.FOUND);
 		}
 		else 
 		{
 			 throw new PhoneNotFound(null);
 		}
	}
		
    public ResponseEntity<ResourseStructure<List<Employee>>> findEmployeeBySalaryGreaterThan(double salary)
    {
    	 List<Employee> employee = dao.findEmployeeBySalaryGreaterThan(salary);
 		ResourseStructure<List<Employee>> structure =new ResourseStructure<>();
 		
 		if(employee!=null)
 		{
 			 structure.setMessage("find Seccssfuly");
 			 structure.setStatus(HttpStatus.FOUND.value());
 			 structure.setData(dao.findEmployeeBySalaryGreaterThan(salary));
 			 return  new ResponseEntity<ResourseStructure<List<Employee>>>(structure,HttpStatus.FOUND);
 		}
 		else 
 		{
 			 throw new SalaryNotFound("Salary Not found");
 		}
    }
	public ResponseEntity<ResourseStructure<List<Employee>>> fetchAll() {
		// TODO Auto-generated method stub
		 List<Employee> employee = dao.fetchAll();
	 		ResourseStructure<List<Employee>> structure =new ResourseStructure<>();
	 		
	 		if(employee!=null)
	 		{
	 			 structure.setMessage("find Seccssfuly");
	 			 structure.setStatus(HttpStatus.FOUND.value());
	 			 structure.setData(dao.fetchAll());
	 			 return  new ResponseEntity<ResourseStructure<List<Employee>>>(structure,HttpStatus.FOUND);
	 		}
	 		else 
	 		{
	 			 throw new EmployeeListNotFound("List Not found");
	 		}
	}
}

