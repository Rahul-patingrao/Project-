package com.qsp.springbootemployee.exeption;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.springbootemployee.util.ResourseStructure;
@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{
    @ExceptionHandler(IdNotFound.class)
	public ResponseEntity<ResourseStructure<String>> idNotFoundExceptionHandaler(IdNotFound ex) {
		
		ResourseStructure<String> structure = new ResourseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("employee with given Id Not Found");
		return new ResponseEntity<ResourseStructure<String>> (structure,HttpStatus.BAD_REQUEST);
	}
    @ExceptionHandler(EmailNotFound.class)
    public ResponseEntity<ResourseStructure<String>> emailNotFoundExceptionHandaler(EmailNotFound ex) {
		
		ResourseStructure<String> structure = new ResourseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("employee with given Email Not Found");
		return new ResponseEntity<ResourseStructure<String>> (structure,HttpStatus.BAD_REQUEST);
	}
    @ExceptionHandler(EmployeeListNotFound.class)
    public ResponseEntity<ResourseStructure<String>> employeeLisNotFoundExceptionHandaler(EmployeeListNotFound ex) {
	
	ResourseStructure<String> structure = new ResourseStructure<String>();
	structure.setMessage(ex.getMessage());
	structure.setStatus(HttpStatus.BAD_REQUEST.value());
	structure.setData("employee with given Id Not Found");
	return new ResponseEntity<ResourseStructure<String>> (structure,HttpStatus.BAD_REQUEST);
}	@ExceptionHandler(PhoneNotFound.class)
    public ResponseEntity<ResourseStructure<String>> phoneNotFoundExceptionHandaler(PhoneNotFound ex) {
		
		ResourseStructure<String> structure = new ResourseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("employee with given Phone Not Found");
		return new ResponseEntity<ResourseStructure<String>> (structure,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(SalaryNotFound.class)
	public ResponseEntity<ResourseStructure<String>> salaryNotFoundExceptionHandaler(SalaryNotFound ex) {
		
		ResourseStructure<String> structure = new ResourseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("employee with given Id Not Found");
		return new ResponseEntity<ResourseStructure<String>> (structure,HttpStatus.BAD_REQUEST);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> errors =ex.getAllErrors();
		Map<String, String> map = new HashMap<String, String>();
		for (ObjectError objectError : errors) {
			FieldError error =  (FieldError) objectError;
			String field=error.getField();
			String value =error.getDefaultMessage();
			map.put(field, value);
		}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
	}
}
