package com.qsp.springbootemployee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springbootemployee.dao.EmployeeDao;
import com.qsp.springbootemployee.dto.Employee;
import com.qsp.springbootemployee.service.EmployeeService;
import com.qsp.springbootemployee.util.ResourseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;





@RestController
public class EmployeeController {
	@Autowired
	private EmployeeDao dao;
	@Autowired
	private EmployeeService service;
	@PostMapping("/save")
	@ApiOperation(value = "save employee",notes = "using save employee")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "data saved")})
	
	public ResponseEntity<ResourseStructure<Employee>> saveEmployee(@Valid @RequestBody Employee employee) 
	{
		return service.saveEmployee(employee);
	}
	@GetMapping("/find")
	public ResponseEntity<ResourseStructure<Employee>> find( @RequestParam int id) {
		return service.findEmployee(id);
	}
	@GetMapping("/fetchall")
	public ResponseEntity<ResourseStructure<List<Employee>>>  findAll() {
		return service.fetchAll();
		
		
	}
	@DeleteMapping("/delete/{id}")
	 public ResponseEntity<ResourseStructure<Employee>> deleteEmployee( @Validated @PathVariable int id) {
		return service.deleteEmp(id);
	}
	@PutMapping("/update/{id}")
	public Employee upDateEmployee( @PathVariable int id,@RequestBody Employee employee)
	{
		return service.upDateEmployee(id, employee);
	}
	@PatchMapping("/updateEmail/{id}")
	public ResponseEntity<ResourseStructure<Employee>> updateEmail( @PathVariable int id , @RequestParam String email) {
		return service . updateEmail(id, email);
	}
	@PatchMapping("/updatePhone/{id}")
	public ResponseEntity<ResourseStructure<Employee>> updatePhone( @PathVariable int id ,@RequestParam long phone) {
		return service.updatePhone(id,phone);
	}
	@PatchMapping("/updateSalary{id}")
	public ResponseEntity<ResourseStructure<Employee>> updateSalary(@PathVariable int id, @RequestParam double salary) {
		
		return service.updateSalary(id,salary);
	}
	@GetMapping ("/findByEmail")
	public ResponseEntity<ResourseStructure<Employee>> findByEmail( @RequestParam String email) 
	{
		return service.findByEmail(email);
	}
	@GetMapping("/getByPhone")
	 public  ResponseEntity<ResourseStructure<Employee>> getEmployeeByPhone( @RequestParam long phone)
		{
		 return	service.getEmployeeByPhone(phone);
		}
	@GetMapping("/getSalary")
	public ResponseEntity<ResourseStructure<List<Employee>>> findEmployeeBysalaryGreatarThan(@RequestParam double salary)
     {
    	 return service.findEmployeeBySalaryGreaterThan(salary);
     }
}

