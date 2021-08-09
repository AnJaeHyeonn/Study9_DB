package com.ajh.s1.employee;

import java.util.ArrayList;

public class EmployeeView {

	public void view(EmployeeDTO emDTO) {

		System.out.print(emDTO.getEmployee_id() + "\t");
		System.out.print(emDTO.getFirst_name() + "\t");
		System.out.print(emDTO.getLast_name() + "\t");
		System.out.print(emDTO.getEmail() + "\t");
		System.out.print(emDTO.getPhone_number() + "\t");
		System.out.print(emDTO.getHire_date() + "\t");
		System.out.print(emDTO.getJob_id() + "\t");
		System.out.print(emDTO.getSalary() + "\t");
		System.out.print(emDTO.getCommission_pct() + "\t");
		System.out.print(emDTO.getManager_id() + "\t");
		System.out.println(emDTO.getDepartment_id() + "\t");

	}

	public void view(ArrayList<EmployeeDTO> ar) {

		for (int i = 0; i < ar.size(); i++) {
			this.view(ar.get(i));
		}
	}

	public void view(double i) {
		System.out.println("전체 평균급여 : " + i);
	}

}
