package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pojos.Employee;
import static utils.DBUtils.*;

public class EmpDaoImpl implements EmpDao {
	// D.M
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3;

	public EmpDaoImpl() throws Exception {
		cn = getConnection();
		pst1 = cn.prepareStatement("select * from my_emp where deptid = ? and join_date > ?");
		pst2 = cn.prepareStatement("insert into my_emp values(default,?,?,?,?,?)");
		pst3 = cn.prepareStatement("update my_emp set deptid=? , salary=salary+? where empid=?");
		System.out.println("dao created...");
	}

	public void cleanUp() throws Exception {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		if (cn != null)
			cn.close();
		System.out.println("dao cleaned up");
	}

	@Override
	public List<Employee> getEmpDetails(String dept, String joinDate) throws Exception {
		// set IN params
		pst1.setString(1, dept);
		pst1.setDate(2, Date.valueOf(joinDate));
		// AL
		ArrayList<Employee> l1 = new ArrayList<>();
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				l1.add(new Employee(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDouble(4), dept,
						rst.getDate(6)));
		}
		return l1;
	}

	@Override
	public String hireEmp(Employee e) throws Exception {
		// set IN params
		pst2.setString(1, e.getName());
		pst2.setString(2, e.getAddress());
		pst2.setDouble(3, e.getSalary());
		pst2.setString(4, e.getDeptId());
		pst2.setDate(5, e.getJoinDate());
		int updateCount = pst2.executeUpdate();
		if (updateCount == 1)
			return "Emp hired successfully!";
		return "Emp hiring failed....";
	}

	@Override
	public String updateEmpDetails(String dept, double incr, int empId) throws Exception {
		//set In params
		pst3.setString(1, dept);
		pst3.setDouble(2, incr);
		pst3.setInt(3, empId);
		int updateCount = pst3.executeUpdate();
		if (updateCount == 1)
			return "Emp details updated successfully!";
		return "Emp details updation failed....";
	}
	

}
