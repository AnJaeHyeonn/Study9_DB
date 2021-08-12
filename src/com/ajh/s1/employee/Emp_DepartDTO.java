package com.ajh.s1.employee;

import com.ajh.s1.department.DepartmentDTO;

public class Emp_DepartDTO extends EmployeeDTO {

	private DepartmentDTO departmentDTO;

	public DepartmentDTO getDepartmentDTO() {
		return departmentDTO;
	}

	public void setDepartmentDTO(DepartmentDTO departmentDTO) {
		this.departmentDTO = departmentDTO;
	}

}
