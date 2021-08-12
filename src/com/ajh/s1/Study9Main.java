package com.ajh.s1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ajh.s1.department.Depart_EmpDTO;
import com.ajh.s1.department.DepartmentDAO;
import com.ajh.s1.department.DepartmentDTO;
import com.ajh.s1.employee.EmployeeController;
import com.ajh.s1.location.LocationController;
import com.ajh.s1.location.LocationDAO;

public class Study9Main {
	public static void main(String[] args) {

//		LocationController lc = new LocationController();
//
//		EmployeeController ec = new EmployeeController();
//
//		ec.start();

		DepartmentDAO dDAO = new DepartmentDAO();
		DepartmentDTO departmentDTO = new DepartmentDTO();

		departmentDTO.setDepartment_id(100);

		Depart_EmpDTO demDTO = dDAO.getJoin(departmentDTO);

		System.out.println(demDTO.getDepartment_name());
		System.out.println("=====================================");

		for (int i = 0; i < demDTO.getAr().size(); i++) {

			System.out.print(demDTO.getAr().get(i).getLast_name() + "\t");
			System.out.print(demDTO.getAr().get(i).getSalary() + "\t");
			System.out.println(demDTO.getAr().get(i).getHire_date());
			System.out.println("=====================================");
		}

	}

}
