package tester;

import java.sql.Date;
import java.util.Scanner;

import dao.EmpDaoImpl;
import pojos.Employee;

public class TestEmpCRUD {

	public static void main(String[] args) throws Exception {
		EmpDaoImpl dao = null;
		try (Scanner sc = new Scanner(System.in)) {
			dao = new EmpDaoImpl();
			boolean exit = false;
			while (!exit) {
				try {
					System.out.println("1 : Fetch Emp Details 2: Hire Emp 10 : Exit");
					System.out.println("Enter Option");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter dept id n join date(yr-mon-day)");

						dao.getEmpDetails(sc.next(), sc.next()).forEach(System.out::println);
						System.out.println("Emp List");
						break;

					case 2:
						System.out.println("Enter emp dtls nm adr sal dept dt(yr-mon-day)");
						System.out.println(dao.hireEmp(new Employee(sc.next(), sc.next(), sc.nextDouble(), sc.next(),
								Date.valueOf(sc.next()))));

						break;

					case 3:
						System.out.println("Enter dept , sal incr & emp id");
						System.out.println(
								dao.updateEmpDetails
								(sc.next(), sc.nextDouble(), sc.nextInt()));
						break;

					case 10:
						exit = true;

						break;

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (dao != null)
				dao.cleanUp();
		}

	}

}
