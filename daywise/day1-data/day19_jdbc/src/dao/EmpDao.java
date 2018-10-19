package dao;

import java.sql.Date;
import java.util.List;

import pojos.Employee;

public interface EmpDao {
	List<Employee> getEmpDetails(String dept, String joinDate) throws Exception;
	String hireEmp(Employee e) throws Exception;
	String updateEmpDetails(String dept, double incr,int empId) throws Exception;
}
