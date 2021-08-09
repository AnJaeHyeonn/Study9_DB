package com.ajh.s1;

import java.sql.Connection;
import java.sql.SQLException;

import com.ajh.s1.employee.EmployeeController;
import com.ajh.s1.location.LocationController;
import com.ajh.s1.location.LocationDAO;

public class Study9Main {
	public static void main(String[] args) {

		LocationController lc = new LocationController();
		
		EmployeeController ec = new EmployeeController();

		ec.start();

	}

}
